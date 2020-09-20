package ru.bmstu.iu4.Task1

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

internal class FunctionsKtTest {

    @Test
    fun convertValidTest() {
        val args = arrayOf("5", "7", "3", "9")
        assertEquals(listOf(5, 7, 3, 9), convert(args))
    }

    @Test
    fun convertInValidTest() {
        val args = arrayOf("5", "notNumber", "3", "9")
        assertFails { convert(args) }
    }

    @Test
    fun arraySizeTestNotEmpty() {
        val list = listOf(5, 7, 3, 9)
        assertEquals(expected = 4, arraySize(list))
    }

    @Test
    fun sortingTest() {
        val list = listOf(5, 7, 3, 9)
        assertEquals(expected = listOf(3, 5, 7, 9), sorting(list))
    }
}