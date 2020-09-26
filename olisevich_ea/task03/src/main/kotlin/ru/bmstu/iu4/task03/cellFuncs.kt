package ru.bmstu.iu4.task03

import kotlin.math.ceil

typealias CellPattern = MutableList<MutableList<LineTypes>>
typealias Cell = MutableList<MutableList<String>>

/**
 * Coloring. Transform [CellPattern] to [Cell].
 */
fun CellPattern.toCell() = map { row -> row.map { cell -> cell.ch } } as Cell

/**
 * Fill data to coloring [Cell]
 */
fun Cell.fillData(hAlign: Int, vAlign: Int, data: String, strLen: Int, colLen: Int): Cell {
    for (s in 0 until strLen) {
        var c = 0;
        while (c < colLen && s * colLen + c < data.length) {
            val cellData = this[s + vAlign - 1][c + hAlign - 1]
            if (cellData.length > 1) {
                this[s + vAlign - 1][c + hAlign - 1] =
                    data[s * colLen + c].toString() + cellData.takeLast(cellData.length - 1)
            } else
                this[s + vAlign - 1][c + hAlign - 1] = data[s * colLen + c].toString()
            c++
        }

    }

    return this
}

fun Cell.stringify() = joinToString("\n") { item -> item.joinToString("") }

fun String.toCell(
        width: Int,
        height: Int,
        left: Boolean = true,
        right: Boolean = true,
        top: Boolean = true,
        bot: Boolean = true
): Cell {
    val colLen = width
    val sy: Int = 2 + colLen
    val sx: Int = 2 + height

    val cell: CellPattern = MutableList(sx) { MutableList(sy) { LineTypes.NN } }
    if (right)
        cell.forEach { it.add(it.lastIndex + 1, LineTypes.VS) }

    if (left)
        cell.forEach { it.add(0, LineTypes.VS) }

    if (top) {
        val topline = MutableList(cell[0].size) { LineTypes.HS }
        topline[0] = if (left) LineTypes.NN else LineTypes.HS
        topline[topline.lastIndex] = if (right) LineTypes.NN else LineTypes.HS
        cell.add(0, topline)
    }

    if (bot) {
        val botline = MutableList(cell[0].size) { LineTypes.HS }
        if (left) botline[0] = LineTypes.VS
        if (right) botline[botline.lastIndex] = LineTypes.VS
        cell.removeAt(cell.lastIndex)
        cell.add(cell.lastIndex + 1, botline)
    }

    val horizAlign = if (left) 3 else 2
    val vertAlign = ceil((cell.size - ceil(length / width.toFloat()).toInt()) / 2.toFloat()).toInt() + 1

    val strLen = ceil(length / colLen.toFloat()).toInt()
    return cell.toCell().fillData(horizAlign, vertAlign, this, strLen, colLen)
}