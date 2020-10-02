package ru.bmstu.iu4.sem04.table

data class Row(val cells: MutableList<Cell>) {

    constructor(vararg cells: Cell) : this(cells.toMutableList())

    constructor(vararg texts: String, width: Int, height: Int) :
            this(texts.map { Cell(it, width, height) }.toMutableList())

    fun adjustHeight() {

    }

    /**
     *        0              1              2
     *  |------------| |------------| |------------|
     *  |            | |            | |            |
     *  |   hello    | |   .....    | |   11111    |
     *  |            | |            | |            |  <- line
     *  |------------| |------------| |------------|
     */
    fun build(): String {
        val tmp = cells.map { it.build().split("\n") }                         //поэлементное изменение
        val transpose = Array(tmp[0].size) { i -> Array(tmp.size) { j -> tmp[j][i] } }  // лямбда в лямбде
        return transpose.joinToString("\n") { line -> line.joinToString("") }
    }
}