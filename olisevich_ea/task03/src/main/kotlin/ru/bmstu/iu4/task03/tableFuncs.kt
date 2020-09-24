package ru.bmstu.iu4.task03

typealias Table = MutableList<Row>

/**
 * So professional function for building [Table] via [buildRow] from [ConfigTable].
 */

fun ConfigTable.initTable(): Table {
    val res: Table = mutableListOf();
    this.dataTable.mapIndexed() { i, str ->
        when (i) {
            this.dataTable.lastIndex -> res.add(initRow(str, this.maxlen).buildRow())
            else -> res.add(initRow(str, this.maxlen).borderDel("bot").buildRow())
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

fun Table.printTable(): String {
    var res: String = ""
    this.forEach { res += it.printRow() }
    return res
}


