package ru.bmstu.iu4.sem04.table

import org.junit.Test
import ru.bmstu.iu4.sem04.static.center
import ru.inforion.lab403.common.logging.logger
import kotlin.test.assertEquals


internal class Tests {
    companion object {
        val log = logger()
    }

    @Test
    fun buildCellTest() {
        val text = Cell("hello world", 15, 5).apply {
//            top = false
            bottom = true
//            left = false
            right = false
            width = 20
            verticalAlign = "top"
            horizontalAlign = "right"
            horizontalEdge = '+'
        }.build()

        val expected = """
            +--------------------
            +         hello world
            +                    
            +                    
            +                    
            +                    
            +--------------------
        """.trimIndent()
        assertEquals(expected, text)
    }

    @Test
    fun buildRowTest() {
        val text = Row("hello world", "...", "test", width = 15, height = 5).build()

        val expected = """
            |---------------||---------------||---------------|
            |               ||               ||               |
            |               ||               ||               |
            |  hello world  ||      ...      ||     test      |
            |               ||               ||               |
            |               ||               ||               |
            |---------------||---------------||---------------|
        """.trimIndent()

        assertEquals(expected, text)
    }

    @Test
    fun buildTableTest() {
        val t = Table(
            Row("hello world", "...", "test", width = 15, height = 5, rowNum = 0),
            Row("world", "111111", "test222", width = 15, height = 5, rowNum = 1)
        )

        t.adjustHeight()
        t.adjustWidth()

        val text = t.build()

        val expected = """
            |-------------|--------|---------|
            |             |        |         |
            |             |        |         |
            | hello world |  ...   |  test   |
            |             |        |         |
            |-------------|--------|---------|
            |             |        |         |
            |    world    | 111111 | test222 |
            |             |        |         |
            |             |        |         |
            |-------------|--------|---------|
        """.trimIndent()

        assertEquals(expected, text)
    }

}