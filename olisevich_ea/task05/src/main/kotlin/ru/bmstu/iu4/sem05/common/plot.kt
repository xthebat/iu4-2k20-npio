package ru.bmstu.iu4.sem05.common

import java.io.Writer

typealias Plot = Array<CharArray>

fun plot(width: Int, height: Int, init: Char = ' ') = Array(width) { CharArray(height) { init } }

fun Plot.toStr(): String {
    var res = ""
    this.forEach {
        res += it.joinToString("", postfix = "\n")
    }
    return res
}

fun Plot.write(writer: Writer) = forEach {
    //writer.write(it)
    //writer.append('\n') не работает при размере Canvas < 100x100
    println(it)
}