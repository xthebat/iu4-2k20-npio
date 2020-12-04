package ru.bmstu.iu4.sem10

import java.io.InputStream

fun InputStream.readLine() = buildString {
    var lfFound = false
    var crFound = false
    do {
        val value = read()

        if (value == 0x0D) {
            crFound = true
        } else if (crFound && value == 0x0A) {
            lfFound = true
        } else {
            append(value.toChar())
            crFound = false
            lfFound = false
        }
    } while (!lfFound)
}

fun InputStream.lineSequences() = sequence {
    while (true) yield(readLine())
}