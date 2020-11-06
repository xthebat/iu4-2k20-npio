package ru.bmstu.iu4.sem10

import org.pcap4j.packet.EthernetPacket
import org.pcap4j.packet.IpV4Packet
import org.pcap4j.packet.Packet
import org.pcap4j.packet.namednumber.IpNumber
import org.pcap4j.util.IpV4Helper
import ru.inforion.lab403.common.extensions.asUInt
import ru.inforion.lab403.common.logging.logger

class Defragmentor {
    companion object {
        val log = logger()

        inline fun EthernetPacket.modify(action: EthernetPacket.Builder.() -> Packet.Builder): Packet.Builder {
            val builder = builder
            val payload = action(builder)
            builder.payloadBuilder(payload)
            return builder
        }

        inline val IpV4Packet.IpV4Header.payloadLength get() = totalLengthAsInt - ihl * 4
    }

    private class Fragmentation constructor(private val eth: EthernetPacket) {
        private val fragments = mutableSetOf<IpV4Packet>()

        fun add(packet: IpV4Packet) = apply { fragments.add(packet) }

        fun assemble(): Packet {
            val packet = IpV4Helper.defragment(fragments.sortedBy { it.header.fragmentOffset })
            return eth.modify { packet.builder }.build()
        }

        fun ready(): Boolean {
            val last = fragments.find { !it.header.moreFragmentFlag } ?: return false
            val total = last.header.fragmentOffset * 8 + last.header.payloadLength
            return fragments.sumBy { it.header.payloadLength } == total
        }

        override fun toString() = "Fragmentation(eth.type=${eth.header.type} count=${fragments.size})"
    }

    private val packets = mutableMapOf<Int, Fragmentation>()

    /**
     * Add packet fragment [packet]
     * If packet ready after adding fragment then return defragmented packet else null
     *
     * @param packet packet fragment
     *
     * @return defragmented packet if packet is ready or null
     */
    fun addFragment(packet: Packet): Packet? {
        val ip = packet[IpV4Packet::class.java] ?: return packet

        if (ip.header.protocol != IpNumber.UDP) return packet

        if (!ip.header.moreFragmentFlag && ip.header.fragmentOffset.asUInt == 0) return packet

        if (ip.header.dontFragmentFlag) {
            log.warning { "Packet with dontFragmentFlag received" }
            return null
        }

        val id = ip.header.identification.asUInt

        val fragmentation = packets.getOrPut(id) { Fragmentation(packet[EthernetPacket::class.java]) }.add(ip)

        if (!fragmentation.ready()) return null

        packets.remove(id)
        return fragmentation.assemble()
    }
}