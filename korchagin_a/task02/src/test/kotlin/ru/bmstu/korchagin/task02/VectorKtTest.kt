package ru.bmstu.korchagin.task02

import org.junit.Test
import kotlin.test.assertEquals

internal class VectorKtTest{

    @Test
    fun vectorPlusTest(){
        var vectorOne = mutableListOf<Float>(1F, 2F, 3F)
        var vectorTwo = mutableListOf<Float>(1F, 2F, 3F)
        assertEquals(listOf(2F, 4F, 6F), vectorOne + vectorTwo)

        assertEquals(listOf(0F), vectorOne + listOf(1F))
    }

    @Test
    fun vectorMinusTest(){
        val vectorOne = mutableListOf<Float>(1F, 2F, 3F)
        val vectorTwo = mutableListOf<Float>(1F, 2F, 3F)
        assertEquals(listOf(0F, 0F, 0F), vectorOne - vectorTwo)

        assertEquals(listOf(0F), vectorOne - listOf(1F))
    }

    @Test
    fun vectorEqualTest(){
        val vectorOne = mutableListOf<Float>(1F, 2F, 3F)
        val vectorTwo = mutableListOf<Float>(1F, 2F, 3F)
        assertEquals(true, vectorOne equals vectorTwo)

        assertEquals(false, vectorOne equals listOf(1F))
    }

    @Test
    fun vectorTimesTest(){
        val vectorOne = mutableListOf<Float>(1F, 2F, 3F)
        val vectorTwo = mutableListOf<Float>(1F, 2F, 3F)
        assertEquals(14F, vectorOne * vectorTwo)

        assertEquals(0F, vectorOne * listOf(1F))
    }

    @Test
    fun vectorTransponseTest(){
        val vectorOne = mutableListOf<Float>(1F, 2F, 3F)
        val vectorTwo = mutableListOf<List<Float>>(listOf(1F), listOf(2F), listOf(3F))
        assertEquals(vectorTwo, vectorOne.transponseToMatrix())
        assertEquals(vectorOne, vectorTwo.transponseToVector())
    }

    @Test
    fun vectorCrossTest(){
        val vectorOne = mutableListOf<Float>(1F, 2F, 3F)
        val vectorTwo = mutableListOf<Float>(1F, 2F, 3F)
        assertEquals(listOf(0F, 0F, 0F), vectorOne cross vectorTwo)
    }

}