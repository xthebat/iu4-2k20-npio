package ru.bmstu.iu4.sem10

import org.pcap4j.packet.IpV4Packet
import org.pcap4j.packet.Packet
import org.pcap4j.packet.TcpPacket
import ru.inforion.lab403.common.logging.FINER
import ru.inforion.lab403.common.logging.logger
import java.net.InetSocketAddress

class TCPTrafficParser {
    companion object {
        val log = logger(FINER)
    }

    private val sockets = mutableMapOf<Long, TCPSocket>()

    private var newSocketNotifier: TcpSocketHandler? = null

    private val called = mutableSetOf<Long>()

    fun notifyNewSocket(handler: TcpSocketHandler) = apply { newSocketNotifier = handler }
    
    fun processPacket(index: Int, packet: Packet): Boolean {
        val ip = packet[IpV4Packet::class.java] ?: return false

        val tcp = packet[TcpPacket::class.java] ?: return false

//        if (!tcp.header.psh) return false

//        if (tcp.header.dstPort.valueAsInt() != 80 && tcp.header.srcPort.valueAsInt() != 80) return null

//        log.info { "$index -> $tcp" }

        val srcAddr = InetSocketAddress(ip.header.srcAddr, tcp.header.srcPort.valueAsInt())
        val dstAddr = InetSocketAddress(ip.header.dstAddr, tcp.header.dstPort.valueAsInt())
        
        val seq = tcp.header.sequenceNumberAsLong
        val ack = tcp.header.acknowledgmentNumberAsLong

        val socket = sockets[ack]

        if (socket != null) {
            if (tcp.header.fin || tcp.header.rst) {
                log.warning { "Close connection seq=$seq index=$index ack=$ack socket=$socket " }
                socket.close()
                sockets.remove(ack)
                called.remove(ack)
                return true
            }

            if (tcp.header.psh) {
                log.finer { "Fragment for seq=$seq index=$index ack=$ack socket=$socket size=${tcp.payload.rawData.size}" }
                socket.write(tcp)
                return true
            }
        } else if (tcp.header.psh) {
            sockets[ack] = TCPSocket(ack, srcAddr, dstAddr).also {
                log.fine { "Add new socket for seq=$seq index=$index ack=$ack socket=$it" }
                if (ack !in called) {
                    called.add(ack)
                    newSocketNotifier?.invoke(it)
                }
            }
            return true
        }
        
        return false
    }
}