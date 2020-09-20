package ru.bmstu.iu4.task03

import kotlin.math.ceil

/**
 * Enum class with different coloring of table
 */
enum class LineTypes(val ch: String) {
    VS("}{"), HS("^^"), NN("  ")
}


typealias CellPattern = MutableList<MutableList<LineTypes>>
typealias Cell = MutableList<MutableList<String>>


/**
 * Build pattern of cell, coloring and filling data.
 * From input [ConfigRow] receive [Cell] for [Row].
 */
fun ConfigRow.buildCell(data: String): Cell {
    val colLen = this.dataLen
    val sy: Int = 2 + colLen
    val sx: Int = 2 + this.dataHeight

    var cell: CellPattern = MutableList(sx) { MutableList(sy) { LineTypes.NN } }
    if (this.right)
        cell.forEach { it.add(it.lastIndex + 1, LineTypes.VS) }

    if (this.left)
        cell.forEach { it.add(0, LineTypes.VS) }

    if (this.top) {
        val topline = MutableList(cell[0].size) { LineTypes.HS }
        topline[0] = if (this.left) LineTypes.NN else LineTypes.HS
        topline[topline.lastIndex] = if (this.right) LineTypes.NN else LineTypes.HS
        cell.add(0, topline)
    }

    if (this.bot) {
        val botline = MutableList(cell[0].size) { LineTypes.HS }
        if (this.left) botline[0] = LineTypes.VS
        if (this.right) botline[botline.lastIndex] = LineTypes.VS
        cell.removeAt(cell.lastIndex)
        cell.add(cell.lastIndex + 1, botline)
    }

    val horizAlign: Int = if (this.left) 3 else 2
    val vertAlign: Int =
        ceil((cell.size - ceil(data.length / this.dataLen.toFloat()).toInt()) / 2.toFloat()).toInt() + 1

    return cell.toCell().fillData(horizAlign, vertAlign, data, ceil(data.length / colLen.toFloat()).toInt(), colLen);
}

/**
 * Coloring. Transform [CellPattern] to [Cell].
 */
fun CellPattern.toCell(): Cell {
    val res: Cell = MutableList(this.size) { MutableList(this[0].size) { LineTypes.NN.ch } }

    res.forEachIndexed { str, mutableList ->
        mutableList.forEachIndexed { col, _ ->
            res[str][col] = this[str][col].ch
        }
    }

    return res
}

/**
 * Fill data to coloring [Cell]
 */

fun Cell.fillData(hAlign: Int, vAlign: Int, data: String, strLen: Int, colLen: Int): Cell {
    for (s in 0 until strLen) {
        var c = 0;
        while (c < colLen && s * colLen + c < data.length) {
            var cell_data = this[s + vAlign - 1][c + hAlign - 1]
            if (cell_data.length > 1) {
                this[s + vAlign - 1][c + hAlign - 1] =
                    data[s * colLen + c].toString() + cell_data.takeLast(cell_data.length - 1)
            } else
                this[s + vAlign - 1][c + hAlign - 1] = data[s * colLen + c].toString()
            c++
        }

    }

    return this;

}