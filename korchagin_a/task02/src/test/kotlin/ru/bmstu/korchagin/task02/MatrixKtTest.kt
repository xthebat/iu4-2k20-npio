package ru.bmstu.korchagin.task02

import org.junit.Test
import kotlin.test.assertEquals


internal class MatrixKtTest{

    @Test
    fun testMatrixPlus(){
        val matrixOne = mutableListOf<List<Float>>(listOf(1F, 2F, 3F), listOf(1F, 2F, 3F), listOf(1F, 2F, 3F))
        val matrixTwo = mutableListOf<List<Float>>(listOf(1F, 2F, 3F), listOf(1F, 2F, 3F), listOf(1F, 2F, 3F))
        val matrixAnswer = mutableListOf<List<Float>>(listOf(2F, 4F, 6F), listOf(2F, 4F, 6F), listOf(2F, 4F, 6F))

        assertEquals(matrixAnswer, matrixOne + matrixTwo)
    }

    @Test
    fun testMatrixMinus(){
        val matrixOne = mutableListOf<List<Float>>(listOf(1F, 2F, 3F), listOf(1F, 2F, 3F), listOf(1F, 2F, 3F))
        val matrixTwo = mutableListOf<List<Float>>(listOf(1F, 2F, 3F), listOf(1F, 2F, 3F), listOf(1F, 2F, 3F))
        val matrixAnswer = mutableListOf<List<Float>>(listOf(0F, 0F, 0F), listOf(0F, 0F, 0F), listOf(0F, 0F, 0F))

        assertEquals(matrixAnswer, matrixOne - matrixTwo)
    }

    @Test
    fun testMatrixTimes(){
        val matrixOne = mutableListOf<List<Float>>(listOf(1F, 2F, 3F), listOf(1F, 2F, 3F))
        val matrixTwo = mutableListOf<List<Float>>(listOf(1F, 2F), listOf(1F, 2F), listOf(1F, 2F))
        val matrixAnswer = mutableListOf<List<Float>>(listOf(6F, 12F), listOf(6F, 12F))

        assertEquals(matrixAnswer, matrixOne * matrixTwo)
    }

    @Test
    fun testMatrixEquals(){
        val matrixOne = mutableListOf<List<Float>>(listOf(1F, 2F, 3F), listOf(1F, 2F, 3F))
        val matrixTwo = mutableListOf<List<Float>>(listOf(1F, 2F), listOf(1F, 2F), listOf(1F, 2F))

        assertEquals(true, matrixOne equals  matrixOne)
        assertEquals(false, matrixOne equals  matrixTwo)
    }

    @Test
    fun testMatrixTransponse(){
        val matrixOne = mutableListOf<List<Float>>(listOf(1F, 2F, 3F), listOf(1F, 2F, 3F))
        val matrixTwo = mutableListOf<List<Float>>(listOf(1F, 1F), listOf(2F, 2F), listOf(3F, 3F))

        assertEquals(matrixTwo, matrixOne.transonse())
    }
}