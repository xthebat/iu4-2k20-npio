package ru.bmstu.iu4.Sem04.createTable

data class Table(val rows: MutableList<Row>) {

    constructor(vararg rows: Row) : this(rows.toMutableList())

    fun build() = rows.joinToString("\n") { it.build() }
}