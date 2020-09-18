package ru.bmstu.iu4.fadeev

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import ru.inforion.lab403.common.logging.logger

internal class FunctionsKtTest {

    val log = logger()

    @Test
    fun qsort() {

        log.warning{ "qsort test" }

        val inArr: ArrayList<Int> = arrayListOf(7, 3, 9, 2, 0)
        qsort(inArr, 0, 4)
        assertEquals(arrayListOf( 0, 2, 3, 7, 9), inArr)
    }
    @Test
    fun swap() {

        log.warning{ "swap test" }

        val sArr: ArrayList<Int> = arrayListOf(63, 27)
        swap(sArr, 0, 1)
        assertEquals(arrayListOf(27, 63), sArr)
    }
    @Test
    fun swapIsEmpty() {

        log.warning{ "swapIsEmpty test" }
        val sArr: ArrayList<Int> = arrayListOf()
        assertFails { swap(sArr,0, 1) };
    }
}