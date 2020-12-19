package ru.bmstu.iu4.sem10

import org.pcap4j.packet.TcpPacket
import ru.inforion.lab403.common.extensions.asByte
import ru.inforion.lab403.common.extensions.asUInt
import ru.inforion.lab403.common.extensions.buffers.BlockingCircularBytesIO
import java.io.InputStream
import java.io.OutputStream
import java.net.InetSocketAddress

class TCPSocket(val id: Long, val srcAddr: InetSocketAddress, val dstAddr: InetSocketAddress) {

    private val buffer = BlockingCircularBytesIO(Configuration.circularBufferSize)

    private val streams = mutableListOf<InputStream>()

    fun close() = streams.forEach { it.close() }

    val outputStream = object : OutputStream() {
        override fun write(b: Int): Unit = run { buffer.offer(byteArrayOf(b.asByte)) }

        override fun write(b: ByteArray): Unit = run { buffer.offer(b) }

        override fun write(b: ByteArray, off: Int, len: Int): Unit = run { buffer.offer(b, off, len) }
    }

    val inputSteam = object : InputStream() {
        override fun read(): Int {
            val bytes = buffer.take(1)
            return bytes.first().asUInt
        }

        override fun read(b: ByteArray): Int {
            val bytes = buffer.take(b.size)
            bytes.copyInto(b, 0, 0, bytes.size)
            return bytes.size
        }

        override fun read(b: ByteArray, off: Int, len: Int): Int {
            val bytes = buffer.take(len)
            bytes.copyInto(b, off, 0, bytes.size)
            return bytes.size
        }

        override fun available() = buffer.readAvailable
    }.also { streams.add(it) }

    override fun toString() = "TCPSocket(id=$id src=$srcAddr dst=$dstAddr)"
}