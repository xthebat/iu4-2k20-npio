package ru.bmstu.iu4.troshina.task_01

import org.junit.Assert
import org.junit.Test


internal class QSortKtTest {

    @Test
    fun qSortTest() {

        val testArray = arrayOf(1,23,24,54,643,1,3)
        val rightArray = arrayOf(1,1,3,23,24,54,643)
        val resultArray = qSort(testArray, 0, testArray.lastIndex)
        Assert.assertArrayEquals(resultArray,rightArray)

    }
}