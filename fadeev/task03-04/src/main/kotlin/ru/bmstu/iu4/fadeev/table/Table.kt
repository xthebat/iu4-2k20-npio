package ru.bmstu.iu4.fadeev.table

data class Table(val rows: MutableList<Row>) {

    constructor(vararg rows: Row) : this(rows.toMutableList())

    fun build() = rows.joinToString("\n") { it.build() }
}