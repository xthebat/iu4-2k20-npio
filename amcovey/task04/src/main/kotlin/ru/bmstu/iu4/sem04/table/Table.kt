package ru.bmstu.iu4.sem04.table

import ru.inforion.lab403.common.extensions.collect

data class Table(val rows: MutableList<Row>) {

    var tableDoubleFrames = true

    constructor(vararg rows: Row) : this(rows.toMutableList())

    private fun longestTextInColumn(colNum: Int): Int? {
        val strings = mutableListOf<String>()
        this.rows.forEach {
            strings.add(it.cells[colNum].text)
        }
        return strings.maxByOrNull { it.length }?.length
    }

    fun adjustTable() {
        val columnIndices = mutableMapOf<Int, Int>()
        collect(this.rows[0].cells.size) {
            columnIndices.put(it, longestTextInColumn(it)!!)
        }
        columnIndices.keys.forEach { key ->
            rows.forEach {
                it.cells[key].adjustCell(columnIndices[key]?.plus(1))
            }
        }
    }

    fun build() = rows.joinToString("\n") {
        when (it) {
            rows.first() -> it.apply {
                rowTop = true
                rowBottom = tableDoubleFrames
                doubleFrames = tableDoubleFrames
            }.build()
            rows.last() -> it.apply {
                rowTop = true
                rowBottom = true
                doubleFrames = tableDoubleFrames
            }.build()
            else -> if (tableDoubleFrames) it.apply {
                rowTop = true
                rowBottom = true
                doubleFrames = tableDoubleFrames
            }.build() else it.apply {
                rowTop = true
                rowBottom = false
                doubleFrames = tableDoubleFrames }.build()
        }
     }
}