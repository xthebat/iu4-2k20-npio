package ru.bmstu.iu4.sem04.table

import ru.inforion.lab403.common.extensions.addExtension
import ru.inforion.lab403.common.extensions.collect
import ru.inforion.lab403.common.extensions.stretch

data class Cell(
    var text: String,

    var width: Int,
    var height: Int
) {
    var left = true
    var right = true
    var top = true
    var bottom = true

    var verticalEdge = '-'
    var horizontalEdge = '|'

    /**
     *      width
     *   /----------\
     *   |          |
     *  |------------|
     *  |   hello    | > height
     *  |------------|
     */
    fun build(): String {
        val spaces = "%${width}s".format(" ")
        val horizontal = buildString { repeat(width) { append(verticalEdge) } }
        var line: String

       if (text.length <= width)
       {
           var tmp = text.toMutableList()
           for (i in tmp.size until width) {
               if (tmp.size < width) {
                   tmp.add(i, ' ')
               }
               if (tmp.size < width) {
                   tmp.add(0, ' ')
               }
           }
           line = tmp.toString().replace(", ", "").replace("[", "").replace("]", "")
       }
       else
       {
           line = text.stretch(width)
       }

        var totalHeight = height
        if (top) totalHeight++
        if (bottom) totalHeight++

        val center = totalHeight / 2

        // [0, 1, 2, 3 ... totalHeight - 1] -> ["|-------------|",  "|             |", ..... "....]
        // it = 0 -> |-------------|
        // it = 1 -> |             |
        // .....

        return collect(totalHeight) {
            val internal = when (it) {
                0 -> if (top) horizontal else spaces
                center -> line
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