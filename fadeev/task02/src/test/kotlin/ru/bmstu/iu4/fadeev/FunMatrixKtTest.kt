package ru.bmstu.iu4.fadeev

import org.junit.Test

import kotlin.test.assertEquals
import kotlin.test.assertFails

internal class FunMatrixKtTest {

    @Test
    fun matrixNew() {
        val test = matrixNew(listOf("1 2", "3 4", "5 6"));
        val need = arrayListOf(arrayListOf(1F, 2F), arrayListOf(3F, 4F), arrayListOf(5F, 6F));
        assertEquals(need,test)
    }

    @Test
    fun times() {
        val test = matrixNew(listOf("1 2 0", "3 4 0", "5 6 0"));
        val need = matrixNew(listOf("3 6 0", "9 12 0", "15 18 0"));
        test.times(3F)

        assertEquals(need, test)
    }

    @Test
    fun plus() {
        val test = matrixNew(listOf("1 2 0", "3 4 0", "5 6 0"));
        val need = matrixNew(listOf("2 4 0", "6 8 0", "10 12 0"));
        assertEquals(need, test + test)
    }

    @Test
    fun minus() {
        val test = matrixNew(listOf("1 2 0", "3 4 0", "5 6 0"));
        val need = matrixNew(listOf("0 0 0", "0 0 0", "0 0 0"));
        assertEquals(need, test - test)
    }

    @Test
    fun mCrossMatrix() {
        var test = matrixNew(listOf("1 2 0", "3 3 4", "5 8 6"));
        var test2 = matrixNew(listOf("9 7 6", "4 2 5", "2 4 2"));
        val need = matrixNew(listOf("17 11 16", "47 43 41", "89 75 82"));
        assertEquals(need, test.mCrossMatrix(test2))
    }

    @Test
    fun transpose() {
        var test = matrixNew(listOf("9 7 6", "4 2 5", "2 4 2"));
        val need = matrixNew(listOf("9 4 2", "7 2 4", "6 5 2"));
        assertEquals(need, test.transpose())
    }

    @Test
    fun transposeFail() {
        var test = matrixNew(listOf("9 7", "4 5", "5 2"));
        assertFails { test.transpose() }
    }
}