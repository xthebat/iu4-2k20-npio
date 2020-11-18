package ru.bmstu.iu4.sem10

import org.pcap4j.packet.EthernetPacket
import org.pcap4j.packet.IpV4Packet
import org.pcap4j.packet.Packet
import org.pcap4j.packet.TcpPacket
import org.pcap4j.packet.namednumber.IpNumber
import org.pcap4j.util.IpV4Helper
import ru.inforion.lab403.common.extensions.asUInt
import ru.inforion.lab403.common.logging.FINER
import ru.inforion.lab403.common.logging.logger
import java.io.ByteArrayOutputStream
import java.net.Inet4Address

class Defragmentor {
    companion object {
        val log = logger(FINER)

        inline fun EthernetPacket.modify(action: EthernetPacket.Builder.() -> Packet.Builder): Packet.Builder {
            val builder = builder
            val payload = action(builder)
            builder.payloadBuilder(payload)
            return builder
        }

        inline val IpV4Packet.IpV4Header.payloadLength get() = totalLengthAsInt - ihl * 4
    }

    data class Fragment(val index: Int, val tcp: TcpPacket)

    private class Fragmentation(val sequence: Int, val ack: Int) {
        private val fragments = mutableSetOf<Fragment>()

        fun add(index: Int, packet: TcpPacket) = apply { fragments.add(Fragment(index, packet)) }

        fun assemble() = ByteArrayOutputStream().apply {
            fragments.forEach { writeBytes(it.tcp.payload.rawData) }
        }.toByteArray()

//        override fun toString() = "Fragmentation(eth.type=${eth.header.type} count=${fragments.size})"
    }

    private val packets = mutableMapOf<Socket, Fragmentation>()

    data class Address(val ip: Inet4Address, val port: Int)

    data class Socket(val ack: Int, val src: Address, val dst: Address)

    /**
     * Add packet fragment [packet]
     * If packet ready after adding fragment then return defragmented packet else null
     *
     * @param packet packet fragment
     *
     * @return defragmented packet if packet is ready or null
     */
    fun addFragment(index: Int, packet: Packet): ByteArray? {
        val ip = packet[IpV4Packet::class.java] ?: return null

        val tcp = packet[TcpPacket::class.java] ?: return null

        if (!tcp.header.psh) return null

        if (tcp.header.dstPort.valueAsInt() != 80 && tcp.header.srcPort.valueAsInt() != 80) return null

//        log.info { "$index -> $tcp" }

        val srcAddr = Address(ip.header.srcAddr, tcp.header.srcPort.valueAsInt())
        val dstAddr = Address(ip.header.dstAddr, tcp.header.dstPort.valueAsInt())

        val socket = Socket(tcp.header.acknowledgmentNumber, srcAddr, dstAddr)

        val fragmentation = packets.getOrPut(socket) {
            log.fine { "Add new fragmentation for seq=${tcp.header.sequenceNumberAsLong} index=$index ack=${tcp.header.acknowledgmentNumberAsLong} offset=${tcp.header.dataOffsetAsInt} size=${tcp.header.options.size} socket=$socket" }
            Fragmentation(tcp.header.sequenceNumber, tcp.header.acknowledgmentNumber)
        }.also {
            log.finer { "Fragment for seq=${tcp.header.sequenceNumberAsLong} index=$index ack=${tcp.header.acknowledgmentNumberAsLong} offset=${tcp.header.dataOffsetAsInt} size=${tcp.header.options.size} socket=$socket" }
            it.add(index, tcp)
        }

//        val offset = tcp.header.sequenceNumber - fragmentation.sequence
//
//        val extent = tcp.payload.rawData.size - offset

        if (tcp.payload.rawData.size < 1000 || tcp.header.acknowledgmentNumber != fragmentation.ack) {
            packets.remove(socket)
            val result = fragmentation.assemble()
            return result
        }

        return null
    }
}