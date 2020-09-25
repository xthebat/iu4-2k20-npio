package ru.bmstu.iu4.task03

import kotlin.math.ceil

typealias Table = MutableList<Row>

fun Table.stringify() = joinToString() { it.stringify() }

fun Table.addRow(values: List<String>, dataPerLine: Int): Row {
    val maxLen = values.maxBy { it.length }?.length ?: dataPerLine
    val dataHeight = ceil(maxLen / dataPerLine.toFloat()).toInt()
    val row = values.toRow(dataPerLine, dataHeight)
    return row.also { add(it) }
}

// Actually dataPerLine should be here, but this is extensions :(
fun table(): Table = mutableListOf()