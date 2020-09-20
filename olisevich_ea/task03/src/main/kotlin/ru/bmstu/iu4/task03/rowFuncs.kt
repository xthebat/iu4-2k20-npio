package ru.bmstu.iu4.task03

import kotlin.math.ceil

typealias Row = MutableList<Cell>

/**
 * [ConfigRow] and support functions to simplify building
 * [Row]s  in [Table]...
 */
data class ConfigRow(
    val cols: List<String>, var dataLen: Int = 5, var dataHeight: Int = 1,
    var left: Boolean = true, var right: Boolean = true,
    var top: Boolean = true, var bot: Boolean = true
)

fun ConfigRow.bLeftDel(): ConfigRow {
    val conf = this.copy()
    conf.left = false;
    return conf;
}

fun ConfigRow.bRightDel(): ConfigRow {
    val conf = this.copy()
    conf.right = false;
    return conf;
}

fun ConfigRow.bTopDel(): ConfigRow {
    val conf = this.copy()
    conf.top = false;
    return conf;
}

fun ConfigRow.bBotDel(): ConfigRow {
    val conf = this.copy()
    conf.bot = false;
    return conf;
}

/**
 * [ConfigRow] initializer.
 */
fun initRow(data: String, dataPerLine: Int): ConfigRow {
    val columns = data.split(' ');
    val res = ConfigRow(columns);
    res.dataLen = dataPerLine;
    val maxLen = columns.maxBy { it.length }?.length ?: res.dataLen
    res.dataHeight = ceil(maxLen / res.dataLen.toFloat()).toInt()
    return res
}

/**
 * This function building [Row] with [Cell]s from [ConfigRow]
 */
fun ConfigRow.buildRow(): Row {

    val conf = this
    val cellRow: Row = mutableListOf();

    this.cols.forEachIndexed { i, col ->
        when (i) {
            0 -> cellRow.add(conf.buildCell(col))
            cols.lastIndex -> cellRow.add(conf.bLeftDel().buildCell(col))
            else -> cellRow.add(conf.bLeftDel().buildCell(col))
        }
    }

    return cellRow;
}

fun Row.printRow(): String {
    var res: String = "";
    for (j in this[0].indices) {
        for (i in this.indices) {
            for (k in this[i][j].indices) {
                res += (this[i][j][k])
            }

        }
        res += '\n'
    }
    return res
}