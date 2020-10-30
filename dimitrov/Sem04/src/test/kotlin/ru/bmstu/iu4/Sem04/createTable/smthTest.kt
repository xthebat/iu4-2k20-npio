package ru.bmstu.iu4.Sem04.createTable

import org.junit.Test
import ru.inforion.lab403.common.logging.formatters.Newline
import kotlin.test.assertEquals

internal class smthTest {

    @Test
    fun chunkedTest() {
        val test = "123456789987654321"
        var newLine = listOf<String>()
        val width = 3
        val line2 = test.chunked(width)
        if (line2.lastIndex > width) { newLine = line2.dropLast(line2.lastIndex - width) }
        assertEquals(width, newLine.lastIndex)
    }

    @Test
    fun dropTest() {
        val array = arrayOf("1", "2", "3", "4")
        val result = array.dropLast(1)
        val expected = listOf("1", "2", "3")
        assertEquals(expected, result)
    }
}