package ru.bmstu.iu4.common

import java.io.Writer

typealias Plot = Array<CharArray>

fun plot(width: Int, height: Int, init: Char = ' ') = Array(width) {
    CharArray(height) {
        init
    }
}

fun Plot.write() = forEach {
    println(it)
}