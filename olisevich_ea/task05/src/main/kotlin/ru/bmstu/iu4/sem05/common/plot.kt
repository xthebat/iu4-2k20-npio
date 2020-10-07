package ru.bmstu.iu4.sem05.common

import java.io.Writer

typealias Plot = Array<CharArray>

fun plot(width: Int, height: Int, init: Char = ' ') = Array(width) { CharArray(height) { init } }

fun Plot.write(writer: Writer) = forEach {
    writer.write(it)
    writer.appendLine()
}