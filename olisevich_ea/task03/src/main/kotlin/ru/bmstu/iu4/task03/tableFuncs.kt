package ru.bmstu.iu4.task03

import kotlin.math.ceil

typealias Table = MutableList<Row>

data class ConfigTable(val maxlen: Int) {
    var dataTable: MutableList<String> = mutableListOf();
}

/**
 * So professional function for building [Table] via [buildRow] from [ConfigTable].
 */
fun ConfigTable.initTable(): Table {
    val res: Table = mutableListOf();
    this.dataTable.forEachIndexed() { i, str ->
        when (i) {
            0 -> res.add(initRow(str, this.maxlen).bBotDel().buildRow())
            this.dataTable.lastIndex -> res.add(initRow(str, this.maxlen).buildRow())
            else -> res.add(initRow(str, this.maxlen).bBotDel().buildRow())
        }
    }

    return res
}

/**
 * Create [ConfigTable] to build [Table]
 */
fun createTable(row: String, maxLen: Int): ConfigTable {
    val conf = ConfigTable(maxLen);
    conf.dataTable.add(row)
    return conf
}

/**
 * Adding row in [ConfigTable] build
 */
fun ConfigTable.rowAdd(row: String): ConfigTable {
    this.dataTable.add(row)
    return this
}

fun Table.printTable() {
    this.forEach { it.printRow() }
}


