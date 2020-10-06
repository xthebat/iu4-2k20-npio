package ru.bmstu.iu4.sem04.table

import org.junit.Test
import ru.inforion.lab403.common.logging.logger


internal class Tests {
    companion object {
        val log = logger()
    }

    @Test
    fun buildCellTest() {
//        val cell = Cell("hello world", 15, 5)
//        cell.top = false
//        cell.bottom = false

        val text = Cell("hello world", 15, 5).apply {
//            top = false
            bottom = false
//            left = false
            right = false
            width = 20
            horizontalEdge = '+'
        }.build()

        log.info { "\n$text" }  // "\n" + text
    }

    @Test
    fun buildRowTest() {
        val text = Row("hello world", "...", "test", width = 15, height = 5).build()

        log.info { "\n$text" }  // "\n" + text
    }

    @Test
    fun buildTableTest() {
        val text = Table(
            Row("hello world", "...", "test", width = 15, height = 5),
            Row("world", "111111", "test222", width = 15, height = 5)
        ).build()

        log.info { "\n$text" }  // "\n" + text
    }
}