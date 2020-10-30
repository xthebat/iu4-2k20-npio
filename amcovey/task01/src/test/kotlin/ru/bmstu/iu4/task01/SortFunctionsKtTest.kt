package ru.bmstu.iu4.task01

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

internal class SortFunctionsKtTest {

    @Test
    fun bubbleSortIncreaseTest() {
        val x = intArrayOf(1, 200, 3, 6, 0, 100, 15, 10).bubbleSortIncrease()
        val sortedArray = intArrayOf(0, 1, 3, 6, 10, 15, 100, 200)
        Assert.assertArrayEquals(sortedArray, x)
    }

    @Test
    fun quickSortDecreaseTest() {
        val x = intArrayOf(1, 200, 3, 6, 0, 100, 15, 10).quickSortDecrease()
        val sortedArray = intArrayOf(200, 100, 15, 10, 6, 3, 1, 0)
        Assert.assertArrayEquals(sortedArray, x)
    }
//
//    @Test
//    fun makeSort() {
//    }
}