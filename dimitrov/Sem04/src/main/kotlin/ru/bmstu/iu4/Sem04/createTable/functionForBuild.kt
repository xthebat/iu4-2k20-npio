package ru.bmstu.iu4.Sem04.createTable

import ru.inforion.lab403.common.extensions.stretch

fun String.newMaxHeight(width: Int): Int {
    return this.chunked(width).lastIndex
}

/**
 * Сложение строк с пробелами
 */
/*fun listChunked(text: String, width: Int): List<String> {
    val temp = text.split(" ").toMutableList()
    println("input string: $temp")
    val tempList = mutableListOf<String>()
    tempList.add(temp.first())
    println("first in tempList: $tempList")
    temp.removeAt(index = 0)
    println("remove 0 in temp: $temp")
    for ((index, element) in temp.withIndex()) {


        /*if (tempList[index].length + temp[index].length + 1 <= width) {
            tempList[index] = tempList[index].plus(" ").plus(element)
            temp.removeAt(index)
        }
        else tempList.add(element)*/


        println("delete in circle: $temp")
        println("add in circle: $tempList")
    }
    return tempList
} */

fun listChunked(text: String, width: Int): List<String> {
    return text.chunked(width)
}

fun maxWidth(vararg strings: String, width: Int): Int {
    var tempMaxWidth = width
    for (element in strings) {
        val temp = element.split(" ")
        for (items in temp) if (items.length > tempMaxWidth) tempMaxWidth = items.length
    }
    return tempMaxWidth
}

fun maxHeight(vararg strings: String, width: Int): Int {
    var tempMaxHeight = 1
    for (element in strings) {
        val temp = element.chunked(width)
        if (temp.lastIndex > tempMaxHeight) tempMaxHeight = temp.lastIndex
    }
    return tempMaxHeight+1
}

fun String.centralization(width: Int): String {
    val temp: String
    var emptySpace = width - this.length
    if (emptySpace == 1) emptySpace = 2
    temp = if (this.length == width) this else "%${emptySpace/2}s".format(" ").plus(this).plus("%${emptySpace/2}s".format(" "))
    return temp.stretch(width)
}

fun buildInTable(line: Int, rows: Int): Array<Array<Int>> {
    val constructorCase = Array(line) { Array(rows) { 4 } }
    constructorCase[0][0] = 1
    for (i in 1 until rows) constructorCase[0][i] = 2
    for (i in 1 until line) constructorCase[i][0] = 3
    return constructorCase
}

fun counter(value: Int): MutableList<Int> {
    val list = mutableListOf<Int>()
    for (i in 0 until value) {
        list.add(i)
    }
    return list
}