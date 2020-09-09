package ru.bmstu.iu4.task01

import org.junit.Test
import kotlin.test.assertEquals

internal class SortFunctionsKtTest {

    @Test
    fun bubbleSortIncreaseTest() {
        val x = intArrayOf(1, 200, 3, 6, 0, 100, 15, 10)
        val sortedArray = intArrayOf(0, 1, 3, 6, 10, 15, 100, 200)
        x.bubbleSortIncrease()
        for ((index, value) in sortedArray.withIndex()){
            assertEquals(value, x[index])
        }
    }

    @Test
    fun quickSortDecreaseTest() {
        val x = intArrayOf(1, 200, 3, 6, 0, 100, 15, 10)
        val sortedArray = intArrayOf(200, 100, 15, 10, 6, 3, 1, 0)
        x.quickSortDecrease()
        for ((index, value) in sortedArray.withIndex()){
            assertEquals(value, x[index])
        }
    }
//
//    @Test
//    fun makeSort() {
//    }
}