package ru.bmstu.iu4.sem02

import org.junit.Test
import ru.inforion.lab403.common.logging.logger
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class FunctionsTest {
    val log = logger()

    @Test
    fun squareOutOfPlaceTest() {
        val y = listOf(1, 2, 3)
        val x = squareOutOfPlace(y)
        log.info { x }
        assertEquals(listOf(1, 4, 9), x)
    }

    @Test
    fun squareInPlaceTest() {
        val y = mutableListOf(1, 2, 3)
        log.info { y }
        squareInPlace(y)
        log.info { y }
        assertEquals(listOf(1, 4, 9), y)
    }

    @Test
    fun squareValidTest() {
        assertEquals(listOf(1, 4, 9), listOf(1, 2, 3).square())
    }

    @Test
    fun squareFailTest() {
        assertNotEquals(listOf(1, 2, 3), listOf(1, 2, 3).square())
    }

    @Test
    fun toStringListValidTest() {
        assertEquals(listOf("1", "4", "9"), listOf(1, 4, 9).toStringList())
    }

    @Test
    fun toLongListValidTest() {
        val expected: List<Long> = listOf(1, 4, 9)
        val actual = listOf(1, 4, 9).toLongList()
        assertEquals(expected, actual)
    }

    @Test
    fun parseInt16ValidTest() {
        val expected = listOf(5, 13, 15)
        val actual = listOf("5", "D", "F").parseInt(16)
        assertEquals(expected, actual)
    }

    @Test
    fun parseInt8ValidTest() {
        val expected = listOf(5, 11, 13)
        val actual = listOf("5", "13", "15").parseInt(radix = 8)
        assertEquals(expected, actual)
    }

    @Test
    fun parseInt10ValidTest() {
        val expected = listOf(5, 13, 15)
        val actual = listOf("5", "13", "15").parseInt()
        assertEquals(expected, actual)
    }

    @Test
    fun concatStringValidTest() {
        val expected = listOf("5", "10", "20", "21", "22")
        val actual = listOf("5", "10", "20") concat listOf("21", "22") concat listOf("31", "31")
        assertEquals(expected, actual)
    }

    @Test
    fun concatIntValidTest() {
        val expected = listOf(5, 10, 20, 21, 22)
        val actual = listOf(5, 10, 20) concat listOf(21, 22)
        assertEquals(expected, actual)
    }
}