package ru.bmstu.iu4.task03.table

data class Table( val rows: MutableList<Row>){
    constructor(vararg cells: Row) : this(cells.toMutableList())

    fun build(): String = rows.joinToString ( "\n" ) {it.build()}
}