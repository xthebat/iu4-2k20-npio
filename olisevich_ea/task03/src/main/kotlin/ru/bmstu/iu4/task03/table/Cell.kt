package ru.bmstu.iu4.task03.table

import ru.inforion.lab403.common.extensions.collect
import ru.inforion.lab403.common.extensions.stretch

data class Cell(
    val text: String, val width: Int,
    val height: Int

) {
    var top = true
    var left = true
    var bot = true
    var right = true
    var verticalEdge = "-"
    var horizontalEdge = "|"

    /**
     *      width
     *  |---------|
     *  |  hello  | > height
     *  |---------|
     */

    fun build(): String {

        val spaces = "%${width}s".format(" ")
        val horizontal = collect(width).joinToString("") {verticalEdge.toString() }
        val line = text.stretch(width)

        var totalheight = height

        if (top) totalheight++
        if (bot) totalheight++

        val center = height / 2

        return collect(height) {
            var internal = when (it) {
                0 -> if (top) horizontal else spaces
                center -> line
                height - 1 -> if (bot) horizontal else spaces
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