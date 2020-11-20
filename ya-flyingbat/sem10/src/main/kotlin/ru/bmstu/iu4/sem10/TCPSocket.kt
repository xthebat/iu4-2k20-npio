package ru.bmstu.iu4.sem10

import org.pcap4j.packet.TcpPacket
import ru.inforion.lab403.common.extensions.asUInt
import java.io.InputStream
import java.net.InetSocketAddress

class TCPSocket(val id: Long, val srcAddr: InetSocketAddress, val dstAddr: InetSocketAddress) {

    private val buffer = BlockingCircularBytesIO(Configuration.circularBufferSize)

    private val streams = mutableListOf<InputStream>()

    fun write(packet: TcpPacket) = buffer.put(packet.payload.rawData)

    fun close() = streams.forEach { it.close() }

    val inputSteam = object : InputStream() {
        override fun read(): Int {
            val bytes = buffer.take(1)
            return bytes.first().asUInt
        }
    }.also { streams.add(it) }

    override fun toString() = "TCPSocket(id=$id src=$srcAddr dst=$dstAddr)"
}