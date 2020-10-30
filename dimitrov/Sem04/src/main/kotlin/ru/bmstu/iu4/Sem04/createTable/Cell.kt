package ru.bmstu.iu4.Sem04.createTable

import ru.inforion.lab403.common.extensions.collect

data class Cell(
    var text: String,

    var width: Int,
    var height: Int,
    val maxHeight: Int,
    val maxWidth: Int,

) {
    var tableHorizontal = 0
    var clearOtherInTable = true
    var left = true
    var right = true
    var top = true
    var bottom = true
    var autoHeightCellSize = true
    var autoWidthCellSize = true

    private var verticalEdge = '-'
    private var horizontalEdge = '|'

    fun build(): String {
        if (autoHeightCellSize) height = maxHeight
        if (autoWidthCellSize) width = maxWidth
        val spaces = "%${width}s".format(" ")
        val horizontal = buildString { repeat(width) { append(verticalEdge) } }

        val newLine = text.chunked(width)

        var totalHeight = height
        if (top) totalHeight++
        if (bottom) totalHeight++
        if (totalHeight<3) totalHeight = 3

        if (clearOtherInTable) {
            when (tableHorizontal) {
                1 -> {left = true; right = true; top = true; bottom = true}
                2 -> {left = false; right = true; top = true; bottom = true}
                3 -> {left = true; right = true; top = false; bottom = true}
                4 -> {left = false; right = true; top = false; bottom = true}
            }
        }

        return collect(totalHeight) {
            val internal = when (it) {
                0 -> if (top) horizontal else spaces
                totalHeight - 1 -> if (bottom) horizontal else spaces

                1 -> newLine[0].centralization(width)
                it -> if (it !=0 && it != totalHeight - 1 && it-1 <= newLine.lastIndex) newLine[it-1].centralization(width) else spaces

                else -> spaces
            }
            buildString {
                if (left) append(horizontalEdge)
                append(internal)
                if (right) append(horizontalEdge)
            }
        }.joinToString("\n")
    }
}