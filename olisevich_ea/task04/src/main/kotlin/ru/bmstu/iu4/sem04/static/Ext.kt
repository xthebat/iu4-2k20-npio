package ru.bmstu.iu4.sem04.static

fun String.center(width: Int): String {
    val s = this;
    return buildString {
        repeat((width-s.length)/2) {append(' ')}
        append(s)
        while (length < width) append(' ')
    }
}