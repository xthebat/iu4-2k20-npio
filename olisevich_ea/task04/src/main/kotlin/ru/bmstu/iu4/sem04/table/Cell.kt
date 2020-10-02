package ru.bmstu.iu4.sem04.table

import ru.bmstu.iu4.sem04.static.center
import ru.inforion.lab403.common.extensions.collect
import ru.inforion.lab403.common.extensions.stretch
import java.util.*

data class Cell(
    var text: String,

    var width: Int,
    var height: Int,
) {
    var left = true
    var right = true
    var top = true
    var bottom = true

    var verticalEdge = '-'
    var horizontalEdge = '|'

    var horizontalAlign = "center"
    var verticalAlign = "mid"

    var maxChars = 15

    /**
     *      width
     *   /----------\
     *   |          |
     *  |------------|
     *  |   hello    | > height
     *  |------------|
     *
     *  VerticalAlign: top, bot & mid.
     *  HorizontalAlign: center, left, right.
     *
     *  Maxlen: slicing string chars to lines.
     */
    fun build(): String {
        val spaces = "%${width}s".format(" ")
        val horizontal = buildString { repeat(width) { append(verticalEdge) } }

        val dataLines = collect(text.length / maxChars+1){
            val min = 0+(it*maxChars)
            val max = text.length.coerceAtMost(maxChars+maxChars*it) -1
            val line = text.slice(min..max)
            when (horizontalAlign){
                "center" -> line.center(width)
                "right" -> line.stretch(width, false )
                else -> line.stretch(width)
            }
        }.toCollection(LinkedList())

        var totalHeight = height

        if (top) totalHeight++
        if (bottom) totalHeight++

        val center = totalHeight / 2

        val verticalMinPos = when (verticalAlign) {
            "top" -> 1
            "bot" -> totalHeight - 1 - dataLines.size
            else -> if (!top) center - 1 else center
        }

        val verticalMaxPos = verticalMinPos + dataLines.size

        return collect(totalHeight) {
            val internal = when (it) {
                0 -> if (top) horizontal else spaces
                in (verticalMinPos until verticalMaxPos) -> dataLines.pop()
                totalHeight - 1 -> if (bottom) horizontal else spaces
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