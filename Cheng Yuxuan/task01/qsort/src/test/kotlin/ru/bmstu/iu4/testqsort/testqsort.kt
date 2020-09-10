package ru.bmstu.iu4.testqsort

import jdk.nashorn.internal.objects.NativeRegExp.test
import org.junit.Test
import ru.bmstu.iu4.qsort.qSort
import kotlin.test.assertEquals

internal class QSortKtTest {

    @Test
    fun qSortTest() {
        val testArray: Array<Int> = arrayOf(1,23,24,54,643,1,3)
        val rightArray: Array<Int> = arrayOf(1,1,3,23,24,54,643)
        val resultArray: Array<Int> = qSort(testArray, 0, testArray.lastIndex)
        for ((index, value) in rightArray.withIndex()){
            assertEquals(value, resultArray[index])
        }
    }
}