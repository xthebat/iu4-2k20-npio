package ru.bmstu.iu4.task03.table

import org.junit.Test

internal class CellTest {

    @Test
    fun build() {
        val cell = Cell("hello world", width = 15, height = 3).apply {
            bot = true
            top = true
            left = true
            right = true
        }

        val text = cell.build()
        println(text)
    }

    @Test
    fun buildRow() {
        val text = Row("hello world", "...", "test", width = 15, height = 5).build()

        println(text)

    }

    @Test
    fun buildTable(){
        //val text =
    }

}