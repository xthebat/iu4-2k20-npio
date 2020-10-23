package ru.bmstu.iu4.fadeev

import org.junit.Test

import kotlin.test.assertEquals
import kotlin.test.assertFails

internal class FunVectorKtTest {

    @Test
    fun vectorNew() {
        val test = vectorNew("4, 5, 6")
        val need = arrayListOf(4F, 5F, 6F)
        assertEquals(need, test)
    }

    @Test
    fun times() {
        val test = vectorNew("1, 2, 3")

        test.times(3F)
        val needF = arrayListOf(3F, 6F, 9F)
        assertEquals(needF, test)

        val needV = arrayListOf(9F, 36F, 81F)
        assertEquals(needV, test * test)
    }

    @Test
    fun plus() {
        val test = arrayListOf(4F, 6F, 8F)
        val need = arrayListOf(8F, 12F, 16F)
        assertEquals(need, test + test)
    }

    @Test
    fun minus() {
        val test = arrayListOf(4F, 6F, 8F)
        val need = arrayListOf(0F, 0F, 0F)
        assertEquals(need, test - test)
    }

    @Test
    fun vCrossMatrix() {
        val testV = vectorNew("1, 2, 4")
        val testM = matrixNew(listOf("0 0 1", "1 0 0", "0 2 0"));
        val need = vectorNew("1, 4, 4")
        assertEquals(need, testV.vCrossMatrix(testM))
    }

    @Test
    fun vCrossMatrixFail() {
        val testV = vectorNew("1, 2")
        val testM = matrixNew(listOf("0 0 1", "1 0 0", "0 2 0"));
        assertFails { testV.vCrossMatrix(testM) }
    }
}