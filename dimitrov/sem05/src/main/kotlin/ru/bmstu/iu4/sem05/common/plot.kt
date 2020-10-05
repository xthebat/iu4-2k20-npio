package ru.bmstu.iu4.sem05.common

import java.io.Writer

typealias Plot = Array<CharArray>

fun plot(canvas: Array<CharArray>) = canvas

fun Plot.write(writer: Writer) = forEach {
    writer.write(it)
    writer.appendLine()
}