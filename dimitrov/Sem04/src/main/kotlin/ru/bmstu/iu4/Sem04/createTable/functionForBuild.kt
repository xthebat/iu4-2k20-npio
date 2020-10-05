package ru.bmstu.iu4.Sem04.createTable

import ru.inforion.lab403.common.extensions.stretch

fun String.newMaxHeight(width: Int): Int {
    return this.chunked(width).lastIndex
}

fun maxWidth(vararg strings: String, width: Int): Int {
    var tempMaxWidth = width
    strings.forEach {
        val temp = it.split(" ")
        temp.forEach { it1 ->
            if (it1.length > tempMaxWidth) tempMaxWidth = it1.length
        }
    }
    return tempMaxWidth
}

fun maxHeight(vararg strings: String, width: Int): Int {
    var tempMaxHeight = 1
    strings.forEach {
        val temp = it.chunked(width)
        if (temp.lastIndex > tempMaxHeight) tempMaxHeight = temp.lastIndex
    }
    return tempMaxHeight+1
}

fun String.centralization(width: Int): String {
    val temp: String
    val emptySpace = (width - this.length).coerceAtLeast(2)
    temp = if (this.length == width) this else "%${emptySpace/2}s".format(" ").plus(this).plus("%${emptySpace/2}s".format(" "))
    return temp.stretch(width)
}

fun buildInTable(line: Int, rows: Int): Array<Array<Int>> {
    return Array(line) { i -> Array(rows) { j ->
        when {
            i == 0 && j == 0 -> 1
            i == 0 -> 2
            j == 0 -> 3
            else -> 4
        }
    } }
}

fun counter(value: Int): MutableList<Int> {
    val list = mutableListOf<Int>()
    for (i in 0 until value) {
        list.add(i)
    }
    return list
}