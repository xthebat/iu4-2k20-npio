package ru.bmstu.iu4.fadeev.table

import ru.inforion.lab403.common.extensions.ceil
import ru.inforion.lab403.common.extensions.collect
import ru.inforion.lab403.common.extensions.stretch

data class Cell(
    var text: String,
    var width: Int,
    var height: Int,

    var rPos: Int,
    var cntRow: Int,
    var maxDataLength: Int,
    var cntChar: Int,
    var adjH: Boolean,
    var adjW: Boolean,
    var doubleBrdOff: Boolean
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
    fun build(cPos: Int): String {
        if (doubleBrdOff) {
            if (rPos >= 1) {
                left = false
                right = true
                top = true
                bottom = false
            }
            if (rPos == cntRow) bottom = true
            if (cPos == 1) left = true
        } else left = true

        var totalHeight = height
        if (adjH) totalHeight = maxDataLength.ceil(cntChar)
        if (adjW) width = cntChar

        val spaces = "%${width}s".format(" ")
        val horizontal = buildString { repeat(width) { append(verticalEdge) } }
        val wordlist = text.chunked(cntChar).map {
            buildString {
                repeat((width - it.length) / 2) { append(' ') }
                append(it)
            }
        }

        if (top) totalHeight++
        if (bottom) totalHeight++
        if (rPos == cntRow && cntChar > maxDataLength) totalHeight++
        if (totalHeight < 3) totalHeight = 3

        return collect(totalHeight) {
            val internal = when (it) {
                0 -> if (top) horizontal else spaces
                totalHeight - 1 -> if (bottom) horizontal else spaces
                it -> if (it != totalHeight - 1 && it - 1 <= wordlist.lastIndex) wordlist[it - 1].stretch(width) else spaces
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