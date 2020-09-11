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

    @Test
    fun convertStrings2IntTest() {

        val str = arrayOf("22", "12", "0")
        val num = arrayOf(22, 12, 0)
        Assert.assertArrayEquals(num, str.convertStrings2Ints())
    }

    @Test
    fun returnArrayOf0(){

        val str = emptyArray<String>()
        val num = arrayOf(0)
        Assert.assertArrayEquals(num, str.convertStrings2Ints())

    }
}