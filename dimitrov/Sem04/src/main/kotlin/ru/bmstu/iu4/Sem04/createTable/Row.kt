package ru.bmstu.iu4.Sem04.createTable

data class Row(val cells: MutableList<Cell>, val tableBuildProtocol: Array<Array<Int>>, val col: MutableList<Int>) {

    constructor(vararg cells: Cell, protocol: Array<Array<Int>>, col: MutableList<Int>) : this(cells.toMutableList(), protocol, col)

    constructor(vararg texts: String, width: Int, height: Int, maxHeight: Int,
                maxWidth: Int, protocol: Array<Array<Int>>, col: MutableList<Int>) :
            this(texts.map { Cell(it, width, height,
                maxHeight, maxWidth)}.toMutableList(), protocol, col)


    /**
     *        0              1              2
     *  |------------| |------------| |------------|
     *  |            | |            | |            |
     *  |   hello    | |   .....    | |   11111    |
     *  |            | |            | |            |  <- line
     *  |------------| |------------| |------------|
     */

    fun build(): String {
        for ((index, it) in cells.withIndex()) it.tableHorizontal = tableBuildProtocol[col[0]][index]
        col.removeAt(0)
        val tmp = cells.map { it.build().split("\n") }
        val transpose = Array(tmp[0].size) { i -> Array(tmp.size) { j -> tmp[j][i] } }
        return transpose.joinToString("\n") { line -> line.joinToString("") }
    }
}