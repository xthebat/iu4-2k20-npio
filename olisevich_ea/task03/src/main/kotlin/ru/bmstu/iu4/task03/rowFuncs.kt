package ru.bmstu.iu4.task03

typealias Row = MutableList<Cell>

fun List<String>.toRow(cellWidth: Int, cellHeight: Int): Row {
    return mapIndexed { index, value -> value.toCell(cellWidth, cellHeight) } as Row
}

fun Row.stringify() = joinToString("\n") { it.stringify() }