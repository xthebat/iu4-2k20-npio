package ru.bmstu.iu4.sem04.table

data class Table(val rows: MutableList<Row>) {

    constructor(vararg rows: Row) : this(rows.toMutableList())

    fun adjustHeight() {

    }

    fun adjustWidth() {

    }

    fun build() = rows.joinToString("\n") { it.build() }
}