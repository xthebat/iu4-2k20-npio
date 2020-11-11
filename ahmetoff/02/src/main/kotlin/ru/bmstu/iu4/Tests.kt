package ru.bmstu.iu4

import org.junit.Test
import kotlin.test.assertEquals

internal class Tests {
    @Test
    fun bubbleSortTest() {
        val data = mutableListOf(1, 3, 2, 6, 7, 0, 9)
        println(data)
        bubbleSort(data)
        println(data)
        assertEquals(mutableListOf(0, 1, 2, 3, 6, 7, 9), data)
        //assertEquals(mutableListOf(0,1,2,3,6,7,8), data)
    }
}