package ru.bmstu.iu4.sem04.table

data class Row(val cells: MutableList<Cell>) {

    var rowBottom = false
    var rowTop = false
    var doubleFrames = false

    constructor(vararg texts: String, width: Int, height: Int) :
            this(texts.map { Cell(it, width, height) }.toMutableList())

    /**
     *        0              1              2
     *  |------------| |------------| |------------|
     *  |            | |            | |            |
     *  |   hello    | |   .....    | |   11111    |
     *  |            | |            | |            |  <- line
     *  |------------| |------------| |------------|
     */
    fun build(): String {
        val tmp = cells.map {
                when (it) {
                    cells.first() -> it.apply {
                        left = true
                        right = doubleFrames
                        bottom = rowBottom
                        top = rowTop }.build().split("\n")
                    cells.last() -> it.apply {
                        right = true
                        left = true
                        bottom = rowBottom
                        top = rowTop }.build().split("\n")
                    else -> it.apply {
                        left = true
                        right = doubleFrames
                        bottom = rowBottom
                        top = rowTop }.build().split("\n")
                }
        }
        val transpose = Array(tmp[0].size) { i -> Array(tmp.size) { j -> tmp[j][i] } }
        return transpose.joinToString("\n") { line -> line.joinToString("") }
    }
}