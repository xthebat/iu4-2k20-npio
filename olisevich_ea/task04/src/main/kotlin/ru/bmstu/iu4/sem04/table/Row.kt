package ru.bmstu.iu4.sem04.table

import ru.bmstu.iu4.sem04.desc.AlignTypes
import kotlin.math.ceil

data class Row(val cells: MutableList<Cell>) {

    constructor(vararg cells: Cell) : this(cells.toMutableList())

    constructor(vararg texts: String, width: Int, height: Int, horizontalAlign: AlignTypes = AlignTypes.Mid,
                verticalAlign: AlignTypes = AlignTypes.Mid, maxChars: Int = 15) :
            this(texts.map {
                Cell(it, width, height).apply {
                    this.horizontalAlign = horizontalAlign
                    this.verticalAlign = verticalAlign
                    this.maxChars = maxChars
                }
            }.toMutableList())

    // RowNum - номер каждой строки в таблице, необходим для ориентации во время постройки таблицы, чтобы удалить двойные границы
    // Ну я стараюсь делать в соответствии с данным на семинаре материалом, чтобы не было путаницы.
    constructor(vararg texts: String, width: Int, height: Int, horizontalAlign: AlignTypes = AlignTypes.Mid,
                verticalAlign: AlignTypes = AlignTypes.Mid, maxChars: Int = 15, rowNum: Int) :
            this(texts.mapIndexed { i, it ->
                var topside: Boolean
                var botside: Boolean
                when (rowNum) {
                    0 -> {
                        topside = true
                        botside = true
                    }
                    else -> {
                        botside = true
                        topside = false
                    }
                }

                when (i) {
                    0 -> Cell(it, width, height).apply {
                        right = false
                        top = topside
                        bottom = botside
                    }
                    texts.size - 1 -> Cell(it, width, height).apply {
                        top = topside
                        bottom = botside
                    }
                    else -> Cell(it, width, height).apply {
                        right = false
                        top = topside
                        bottom = botside
                    }
                }

            }.onEach {
                it.horizontalAlign = horizontalAlign
                it.verticalAlign = verticalAlign
                it.maxChars = maxChars
            }.toMutableList())


    fun adjustHeight() {
        val maxHeightCell = cells.maxBy { it.text.length / it.maxChars }
        if (maxHeightCell != null) {
            val maxHeight = ceil(maxHeightCell.text.length.toDouble() / maxHeightCell.maxChars) + 2
            cells.forEach { it.height = maxHeight.toInt() }
        }

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
        val tmp = cells.map { it.build().split("\n") }
        val transpose = Array(tmp[0].size) { i -> Array(tmp.size) { j -> tmp[j][i] } }
        return transpose.joinToString("\n") { line -> line.joinToString("") }
    }
}