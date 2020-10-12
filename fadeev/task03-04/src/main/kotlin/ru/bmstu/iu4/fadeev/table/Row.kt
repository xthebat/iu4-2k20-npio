package ru.bmstu.iu4.fadeev.table

import ru.bmstu.iu4.fadeev.Starter

data class Row(val cells: MutableList<Cell>) {

    constructor(vararg cells: Cell) : this(cells.toMutableList())

    constructor(vararg texts: String, width: Int, height: Int, rPos: Int, cntRow: Int, maxDataLength: Int, cntChar: Int, adjH: Boolean, adjW: Boolean, doubleBrdOff: Boolean) :
            this(texts.map { Cell(it, width, height, rPos, cntRow, maxDataLength, cntChar, adjH, adjW, doubleBrdOff) }.toMutableList())

    var cPos = 0
    /**
     *        0              1              2
     *  |------------| |------------| |------------|
     *  |            | |            | |            |
     *  |   hello    | |   .....    | |   11111    |
     *  |            | |            | |            |  <- line
     *  |------------| |------------| |------------|
     */
    fun build(): String {
        val tmp = cells.map {cPos++; it.build(cPos).split("\n")  }
        val transpose = Array(tmp[0].size) { i -> Array(tmp.size) { j -> tmp[j][i]}}
        return transpose.joinToString("\n") { line -> line.joinToString("") }
    }
}