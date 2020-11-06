package ru.bmstu.iu4.sem10

import org.pcap4j.core.PcapHandle
import org.pcap4j.core.Pcaps
import org.pcap4j.packet.DnsPacket
import org.pcap4j.packet.Packet
import org.pcap4j.packet.TcpPacket
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger
import org.apache.commons.httpclient.HttpParser
import org.pcap4j.packet.IpPacket
import java.nio.charset.Charset

object Application {
    val log = logger(FINEST)

    val permittedNames = listOf("e-m-b.org")

    fun processDns(packet: Packet, dns: DnsPacket): Boolean {
        val names = dns.header.questions.map { it.qName.name }.toSet()
        log.fine { names }
        return names.any { it in permittedNames }
    }

    fun processHttpRequest(bytes: ByteArray) {
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
    }

    fun processHttpResponse(bytes: ByteArray) {
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

        log.finer { text }
        log.config { headers }
    }

    fun processTcp(packet: Packet, tcp: TcpPacket) {
        if (!tcp.header.psh) return

        if (tcp.header.dstPort.valueAsInt() == 80) {
            processHttpRequest(tcp.payload.rawData)
            return
        }

        if (tcp.header.srcPort.valueAsInt() == 80) {
            processHttpResponse(tcp.payload.rawData)
            return
        }
    }

    private var processing = true

    fun processPacket(packet: Packet) {
//        log.finest { packet }

        val dns = packet[DnsPacket::class.java]

        if (dns != null) {
//            processing = processDns(packet, dns)
        } else if (processing) {
            val tcp = packet[TcpPacket::class.java] ?: return
            processTcp(packet, tcp)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        log.info { "Application started..." }

        val handle = Pcaps.openOffline("temp/test.pcapng")

        handle.loop(-1) { packet: Packet ->
            runCatching { processPacket(packet) }
                .onFailure {
                    log.severe { it.stackTraceToString() }
                }
        }
    }
}