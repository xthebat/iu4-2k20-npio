package ru.bmstu.iu4.task03

import kotlin.math.ceil

typealias Row = MutableList<Cell>

/**
 * Support functions to simplify building
 * [Row]s  in [Table]...
 */

fun ConfigRow.borderDel(side: String): ConfigRow {
    when (side) {
        "left" -> left = false;
        "right" -> right = false;
        "top" -> top = false;
        "bot" -> bot = false;
    }
    return this
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

    this.cols.mapIndexed() { i, col ->
        when (i) {
            0 -> cellRow.add(conf.buildCell(col))
            else -> cellRow.add(conf.borderDel("left").buildCell(col))
        }
    }

    return cellRow;
}

fun Row.printRow(): String {
    var res: String = "";
    this[0].mapIndexed { j, _ ->
        this.mapIndexed { i, v ->
            this[i][j].map {
                res += it
            }

        }
        res += '\n'
    }
    return res
}