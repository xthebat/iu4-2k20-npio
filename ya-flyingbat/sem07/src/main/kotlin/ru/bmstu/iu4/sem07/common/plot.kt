package ru.bmstu.iu4.sem07.common

import ru.inforion.lab403.common.logging.logger
import java.io.OutputStream
import java.io.Writer

typealias Plot = Array<CharArray>

object Pl {
    val log = logger()
}

fun plot(width: Int, height: Int, init: Char = ' ') = Array(height) { CharArray(width) { init } }

val Plot.width get() = first().size

val Plot.height get() = size

fun Plot.draw(x: Int, y: Int, marker: Char) {
    Pl.log.fine { "$x, $y -> $marker" }
    this[height - y - 1][x] = marker
}

fun Plot.write(writer: Writer) = forEach {
    writer.write(it)
    writer.appendLine()
    writer.flush()
}

fun Plot.print(stream: OutputStream = System.out) = write(stream.writer())