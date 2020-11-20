package ru.bmstu.iu4.sem10

import org.pcap4j.core.Pcaps
import org.pcap4j.packet.DnsPacket
import org.pcap4j.packet.Packet
import org.pcap4j.packet.TcpPacket
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger
import ru.inforion.lab403.common.extensions.hexlify
import java.net.InetSocketAddress
import kotlin.concurrent.thread

object Application {
    val log = logger(FINEST)

    val permittedNames = listOf("e-m-b.org")

    fun processHttpRequest(index: Int, bytes: ByteArray) = runCatching {
        val text = bytes.toString(Charsets.US_ASCII)

        val tokens = text.split("\r\n")

        log.finest { text }

        val (method, url, type) = tokens.first().split(" ")

        when (method) {
            "GET" -> {
                val headers = tokens.drop(1)
                    .filter { it.isNotBlank() }
                    .associate {
                        val (name, value) = it.split(":")
                        name to value.trim()
                    }

                val host = headers.getValue("Host")

                if (host in permittedNames) {
                    log.config { "GET -> url = $url type = $type" }
                    log.config { headers }
                }
            }

            "POST" -> {
                log.config { "POST -> $text" }
            }
        }
    }.onFailure {
        log.severe { "Can't parse HTTP-REQUEST packet #$index due to $it\nbytes: ${bytes.hexlify(false)}" }
    }.isSuccess

    fun processHttpResponse(index: Int, bytes: ByteArray) = runCatching {
        val text = bytes.toString(Charsets.US_ASCII)

//        log.finer { text }

        val tokens = text.split("\r\n")

        val (type, code, status) = tokens.first().split(" ")

        val headers = tokens.drop(1)
            .takeWhile { it.isNotBlank() }
            .associate {
                val (name, value) = it.split(":")
                name to value.trim()
            }

//        log.finer { text }
        log.config { headers }
    }.onFailure {
        log.severe { "Can't parse HTTP-RESPONSE packet #$index due to $it\nbytes: ${bytes.hexlify(false)}" }
    }.isSuccess

    private val requiredAddress = InetSocketAddress("10.211.55.3", 54605)

    private val tcpTrafficParser = TCPTrafficParser()
        .notifyNewSocket {
            if (it.dstAddr == requiredAddress) {
                log.severe { "Handling started ${InetSocketAddress("10.211.55.3", 54605)}" }
                val stream = it.inputSteam
                thread {
                    while (true) {
                        val bytes = stream.readNBytes(4096)
                        log.severe { bytes.hexlify() }
                    }
                }
            }
        }

    @JvmStatic
    fun main(args: Array<String>) {
        log.info { "Application started..." }

        val handle = Pcaps.openOffline("temp/test.pcapng")

        var index = 1

        handle.loop(180) { packet: Packet ->
            runCatching {
                tcpTrafficParser.processPacket(index, packet)
                Thread.sleep(20)
            }.onFailure {
                log.severe { it.stackTraceToString() }
            }

            index++
        }
    }
}