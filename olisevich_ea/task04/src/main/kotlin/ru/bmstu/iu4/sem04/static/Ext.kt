package ru.bmstu.iu4.sem04.static

fun String.center(width: Int): String {
    val s = this;
    return buildString {
        var i: Int;
        for (i in 0 until (width - s.length) / 2)
            append(' ')
        append(s)
        while (length < width)
            append(' ')

    }
}