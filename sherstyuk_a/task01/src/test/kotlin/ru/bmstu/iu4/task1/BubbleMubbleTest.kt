package ru.bmstu.iu4.task1

import org.junit.Assert
import org.junit.Test
import ru.bmstu.iu4.task1.BubbleMubble.myBubbleSort
import kotlin.test.assertEquals


internal class BubbleMubbleTest {

    @Test
    fun reversedFibonacciNumbersTest() {
        val list = intArrayOf(8, 5, 3, 2, 1, 1, 0)
        myBubbleSort(list)
        Assert.assertArrayEquals(intArrayOf(0, 1, 1, 2, 3, 5, 8), list)
    }

    @Test
    fun randomNumbersTest() {
        val list = intArrayOf(3, -4, 4, 5, 2, 0, 1)
        myBubbleSort(list)
        Assert.assertArrayEquals(intArrayOf(-4, 0, 1, 2, 3, 4, 5), list)
    }
}