package ru.bmstu.iu4.testqsort
import org.junit.Test
import quick_sort
import kotlin.test.assertEquals

internal class TestQuicksort {
    @Test
    fun qSortTest() {
        val testArray: Array<Int> = arrayOf(452,2,24,84,21,1)
        val rightArray: Array<Int> = arrayOf(1,2,21,24,84,452)
        val resultArray: Array<Int> = quick_sort(testArray, 0, testArray.lastIndex)
        for ((index, value) in rightArray.withIndex()){
            assertEquals(value, resultArray[index])
        }
    }
}