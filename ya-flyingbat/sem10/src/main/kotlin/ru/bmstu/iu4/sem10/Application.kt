package ru.bmstu.iu4.sem10

import org.pcap4j.core.Pcaps
import org.pcap4j.packet.Packet
import ru.inforion.lab403.common.extensions.hexAsUInt
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger
import java.io.InputStream
import java.nio.charset.Charset
import java.util.zip.GZIPInputStream
import kotlin.concurrent.thread

object Application {
    val log = logger(FINEST)

    private fun InputStream.readHTTPHeaders() = lineSequences()
        .takeWhile { it.isNotBlank() }
        .associate {
            val (name, value) = it.split(":")
            name to value.trim()
        }

    private fun process(socket: TCPSocket) {
        val stream = socket.inputSteam

        val line = stream.readLine()

        if (line == "HTTP/1.1 200 OK") {
            val headers = stream.readHTTPHeaders()
            log.info { "Socket: $socket -> $headers" }

            val length = headers["Content-Length"]
            val type = headers["Content-Type"]
            val encoding = headers["Content-Encoding"]

            log.fine { "length = $length type = $type encoding = $encoding" }

            if (encoding == "gzip") {
                val gzipArchiveSize = stream.readLine().hexAsUInt
                log.finer { "gzipArchiveSize = $gzipArchiveSize" }
                val gzip = stream.readNBytes(gzipArchiveSize)
                val data = GZIPInputStream(gzip.inputStream()).readAllBytes()

                if (type != null) {
                    val mime = type.substringBefore(";")
                    val main = mime.substringBefore("/")
                    val secondary = mime.substringAfter("/")

                    when (main) {
                        "text" -> {
                            val charset = type.substringAfterLast("charset=")
                            val content = data.toString(Charset.forName(charset))
                            log.finer { content }
                        }
                        "image" -> {
                            log.finest { "IMAGE!" }
                        }
                        "application" -> {
                            log.finest { "APPLICATION!" }
                        }
                    }
                }
            }
        }
    }

    private val tcpTrafficParser = TCPTrafficParser()
        .notifyNewSocket { socket ->
            if (socket.dstAddr.port == 80 || socket.srcAddr.port == 80) {
                thread { process(socket) }
            }
        }

    @JvmStatic
    fun main(args: Array<String>) {
        log.info { "Application started..." }

        val handle = Pcaps.openOffline("temp/test.pcapng")

        var index = 1

        handle.loop(-1) { packet: Packet ->
            runCatching {
                tcpTrafficParser.processPacket(index, packet)
                Thread.sleep(20)
            }.onFailure {
                log.severe { it.stackTraceToString() }
            }

            index++
        }

        log.info { "Application finished" }
    }
}