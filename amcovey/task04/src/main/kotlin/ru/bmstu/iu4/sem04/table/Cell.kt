package ru.bmstu.iu4.sem04.table

import ru.inforion.lab403.common.extensions.collect
import ru.inforion.lab403.common.extensions.stretch

data class Cell(
    var text: String,

    var width: Int,
    var height: Int,
) {
    var left = false
    var right = false
    var top = true
    var bottom = true

    var centerAlign = true

    var verticalEdge = '-'
    var horizontalEdge = '|'
    private var spaces = "%${width}s".format(" ")

    private fun MutableList<String>.popFirstElement(): String{
        return if (!isEmpty()){
            val item = first()
            remove(item)
            item
        }
        else {
            spaces
        }
    }

    fun adjustCell(newWidth: Int?){
        width = newWidth!!
        spaces = "%${width}s".format(" ")
    }

    /**
     *      width
     *   /----------\
     *   |          |
     *  |------------|
     *  |   hello    | > height
     *  |------------|
     */
    fun build(): String {
//        val spaces = "%${width}s".format(" ")
        val horizontal = buildString { repeat(width) { append(verticalEdge) } }

        val textIntoCell = mutableListOf<String>()
        if (text.length >= width){
            val substringIndices = if (text.length % width == 0) (text.length / width - 1)
            else (text.length / width)
            textIntoCell.add(text.stretch(width))
            collect(substringIndices){
                textIntoCell.add(text
                    .substring(textIntoCell[0].length * (it + 1))
                    .stretch(textIntoCell[0].length))
            }
        }
        else textIntoCell.add(text)

        var totalHeight = height
        if (top) totalHeight++
        if (bottom) totalHeight++

        val center = totalHeight / 2

        return collect(totalHeight) {
            val internal = when (it) {
                0 -> if (top) horizontal else spaces
                in center..(center + textIntoCell.size) -> {
                    val line = textIntoCell.popFirstElement()
                    if (centerAlign){
                        buildString {
                            repeat((width - line.length) / 2 ) { append(" ")}
                            append(line)
                            repeat((width - line.length + 1) / 2 ) { append(" ")}
                        }
                    }
                    else
                        line.padEnd(width, ' ')
                }
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