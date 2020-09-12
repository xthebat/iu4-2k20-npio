package ru.bmstu.iu4.uzenkovD.task01.bubbleSort

import org.junit.Test
import ru.inforion.lab403.common.extensions.DynamicClassLoader.log
import kotlin.test.assertEquals
import kotlin.test.assertFails

internal class BubbleSortFuncsKtTest {

    @Test
    fun convertInputArgs2IntNotEmptyTest() {
        log.config { "Starting convert input array to int not empty test..." }
        val array = arrayOf("10", "3", "1", "4", "7", "2")
        assertEquals(arrayOf(10, 3, 1, 4, 7, 2).contentToString(), convertInputArgs2Int(array).contentToString())
    }

    @Test
    fun convertInputArgs2IntEmptyTest() {
        log.config { "Starting convert input array to int empty test..." }
        val array = emptyArray<String>()
        assertFails { convertInputArgs2Int(array) }
    }

    @Test
    fun bubbleSortDescendNotEmptyTest() {
        log.config { "Starting descending sort array not empty test..." }
        val array = arrayOf(10, 3, 1, 4, 7, 2)
        assertEquals(arrayOf(10, 7, 4, 3, 2, 1).contentToString(), bubbleSortDescend(array).contentToString())
    }

    @Test
    fun bubbleSortDescendEmptyTest() {
        log.config { "Starting descending sort array empty test..." }
        val array = emptyArray<Int>()
        assertFails { bubbleSortDescend(array) }
    }

    @Test
    fun bubbleSortAscendNotEmptyTest() {
        log.config { "Starting ascending sort array not empty test..." }
        val array = arrayOf(10, 3, 1, 4, 7, 2)
        assertEquals(arrayOf(1, 2, 3, 4, 7, 10).contentToString(), bubbleSortAscend(array).contentToString())
    }

    @Test
    fun bubbleSortAscendEmptyTest() {
        log.config { "Starting ascending sort array empty test..." }
        val array = emptyArray<Int>()
        assertFails { bubbleSortAscend(array) }
    }
}
