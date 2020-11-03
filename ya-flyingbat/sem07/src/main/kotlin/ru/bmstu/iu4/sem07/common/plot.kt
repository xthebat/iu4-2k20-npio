package ru.bmstu.iu4.sem07.common

import java.io.OutputStream
import java.io.Writer

typealias Plot = Array<CharArray>

// TODO: convert to class
// http://gameprogrammingpatterns.com/component.html

fun plot(width: Int, height: Int, init: Char = ' ') = Array(height) { CharArray(width) { init } }

val Plot.width get() = first().size

val Plot.height get() = size

fun Plot.marker(x: Int, y: Int) = this[height - y - 1][x]

fun Plot.draw(x: Int, y: Int, marker: Char) {
    this[height - y - 1][x] = marker
}

fun Plot.write(writer: Writer) = forEach {
    writer.write(it)
    writer.appendLine()
    writer.flush()
}

fun Plot.print(stream: OutputStream = System.out) = write(stream.writer())