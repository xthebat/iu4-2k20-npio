package ru.bmstu.iu4.fadeev

import org.junit.Test
import ru.inforion.lab403.common.logging.logger
import ru.bmstu.iu4.fadeev.table.Cell
import ru.bmstu.iu4.fadeev.table.Row
import ru.bmstu.iu4.fadeev.table.Table

import kotlin.test.assertEquals

internal class fulltest {
    val log = logger()

    @Test
    fun buildCell() {
        val test = Cell("Hello", 18, 7, 5, 1, 5, 5, adjH = false, adjW = false, doubleBrdOff = false).build(1)
        val result = """
                        |------------------|
                        |      Hello       |
                        |                  |
                        |                  |
                        |                  |
                        |                  |
                        |                  |
                        |                  |
                        |------------------|
        """.trimIndent()
        log.info { "\n$test" }
        assertEquals(result, test)
    }

    @Test
    fun adjHtrue() {
        val test = Cell("Hello", 10, 7, 5, 1, 5, 5, adjH = true, adjW = false, doubleBrdOff = false).build(1)
        val result = """
                        |----------|
                        |  Hello   |
                        |----------|
        """.trimIndent()
        log.info { "\n$test" }
        assertEquals(result, test)
    }

    @Test
    fun adjWtrue() {
        val test = Cell("Hello", 10, 3, 5, 1, 5, 5, adjH = false, adjW = true, doubleBrdOff = false).build(1)
        val result = """
                        |-----|
                        |Hello|
                        |     |
                        |     |
                        |-----|
        """.trimIndent()
        log.info { "\n$test" }
        assertEquals(result, test)
    }

    @Test
    fun buildRow() {
        val test1 = Cell("Hello", 5, 3, 5, 1, 5, 5, adjH = false, adjW = false, doubleBrdOff = false)
        val test2 = Cell("Hello", 5, 3, 5, 1, 5, 5, adjH = false, adjW = false, doubleBrdOff = false)
        val test3 = Cell("Hello", 5, 3, 5, 1, 5, 5, adjH = false, adjW = false, doubleBrdOff = false)

        val testRow = Row(test1, test2, test3).build()
        val result = """
                        |-----||-----||-----|
                        |Hello||Hello||Hello|
                        |     ||     ||     |
                        |     ||     ||     |
                        |-----||-----||-----|
        """.trimIndent()
        log.info { "\n$testRow" }
        assertEquals(result, testRow)
    }

    @Test
    fun buildTable() {
        val test1 = Cell("Hel 1", 5, 3, 1, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = false)
        val test2 = Cell("Hel 2", 5, 3, 1, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = false)
        val test3 = Cell("Hel 3", 5, 3, 1, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = false)
        val test4 = Cell("Hel 4", 5, 3, 2, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = false)
        val test5 = Cell("Hel 5", 5, 3, 2, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = false)
        val test6 = Cell("Hel 6", 5, 3, 2, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = false)

        val testRow = Row(test1, test2, test3)
        val testRow2 = Row(test4, test5, test6)
        val rows: MutableList<Row> = mutableListOf(testRow, testRow2)

        val testTable = Table(rows.toMutableList()).build()
        val result = """
                        |-----||-----||-----|
                        |Hel 1||Hel 2||Hel 3|
                        |     ||     ||     |
                        |     ||     ||     |
                        |-----||-----||-----|
                        |-----||-----||-----|
                        |Hel 4||Hel 5||Hel 6|
                        |     ||     ||     |
                        |     ||     ||     |
                        |-----||-----||-----|
        """.trimIndent()
        log.info { "\n$testTable" }
        assertEquals(result, testTable)
    }

    @Test
    fun buildTableOffDB() {
        val test1 = Cell("Hel 1", 5, 3, 1, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = true)
        val test2 = Cell("Hel 2", 5, 3, 1, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = true)
        val test3 = Cell("Hel 3", 5, 3, 1, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = true)
        val test4 = Cell("Hel 4", 5, 3, 2, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = true)
        val test5 = Cell("Hel 5", 5, 3, 2, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = true)
        val test6 = Cell("Hel 6", 5, 3, 2, 2, 5, 5, adjH = false, adjW = false, doubleBrdOff = true)

        val testRow = Row(test1, test2, test3)
        val testRow2 = Row(test4, test5, test6)
        val rows: MutableList<Row> = mutableListOf(testRow, testRow2)

        val testTable = Table(rows.toMutableList()).build()
        val result = """
                        |-----|-----|-----|
                        |Hel 1|Hel 2|Hel 3|
                        |     |     |     |
                        |     |     |     |
                        |-----|-----|-----|
                        |Hel 4|Hel 5|Hel 6|
                        |     |     |     |
                        |     |     |     |
                        |-----|-----|-----|
        """.trimIndent()
        log.info { "\n$testTable" }
        assertEquals(result, testTable)
    }
}