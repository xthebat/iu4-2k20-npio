package ru.bmstu.iu4.task02

import org.junit.Test
import ru.bmstu.iu4.task02.matrixFunctions.*
import ru.bmstu.iu4.task02.vectorFunctions.*
import kotlin.test.assertEquals

internal class OperationFunctionsKtTest {

    @Test
    fun vectorPlusEqualTest() {
        val a: Vector = listOf(1F, 2F, 3F)
        val b: Vector = listOf(2F, 1F, -2F)
        val result: Vector = listOf(3F, 3F, 1F)
        assertEquals(result, a + b)
    }
    /* I know that a warning is shown here, but I don't know how to test it otherwise plusAssign operator */
    @Test
    fun vectorPlusAssignEqualTest() {
        var a: Vector = listOf(1F, 2F, 3F)
        val b: Vector = listOf(2F, 1F, -2F)
        val result: Vector = listOf(3F, 3F, 1F)
        a += b
        assertEquals(result, a)
    }

    @Test
    fun vectorMinusEqualTest() {
        val a: Vector = listOf(10F, 12F, 3F)
        val b: Vector = listOf(2F, 12F, -2F)
        val result: Vector = listOf(8F, 0F, 5F)
        assertEquals(result, a - b)
    }
    /* I know that a warning is shown here, but I don't know how to test it otherwise minusAssign operator */
    @Test
    fun vectorMinusAssignEqualTest() {
        var a: Vector = listOf(10F, 12F, 3F)
        val b: Vector = listOf(2F, 12F, -2F)
        val result: Vector = listOf(8F, 0F, 5F)
        a -= b
        assertEquals(result, a)
    }

    @Test
    fun vectorDotEqualTest() {
        val a: Vector = listOf(1F, 2F)
        val b: Vector = listOf(4F, 8F)
        val dotResult = 20F
        assertEquals(dotResult, (a dot b))
    }

    @Test
    fun vectorCrossEqualTest() {
        val a: Vector = listOf(1F, 2F, 3F)
        val b: Vector = listOf(2F, 1F, -2F)
        val result: Vector = listOf(-7F, 8F, -3F)
        assertEquals(result, a cross b)
    }

    @Test
    fun matrix2DPlusEqualTest(){
        val a: Matrix2D = listOf(listOf(1F, 2F, 3F),
                                           listOf(5F, 6F, 7F),
                                           listOf(10F, 15F, 20F))
        val b: Matrix2D = listOf(listOf(0F, 5F, 13F),
                                           listOf(6F, 1F, 10F),
                                           listOf(1F, 11F, 50F))
        val result: Matrix2D = listOf(listOf(1F, 7F, 16F),
                                                listOf(11F, 7F, 17F),
                                                listOf(11F, 26F, 70F))
        assertEquals(result, (a + b))
    }

    @Test
    fun matrix2DMinusEqualTest(){
        val a: Matrix2D = listOf(listOf(1F, 2F, 3F),
            listOf(5F, 6F, 7F),
            listOf(10F, 15F, 20F))
        val b: Matrix2D = listOf(listOf(0F, 5F, 13F),
            listOf(6F, 1F, 10F),
            listOf(1F, 11F, 50F))
        val result: Matrix2D = listOf(listOf(1F, -3F, -10F),
            listOf(-1F, 5F, -3F),
            listOf(9F, 4F, -30F))
        assertEquals(result, (a - b))
    }

    @Test
    fun matrix2DMultiplicationEqualTest(){
        val a: Matrix2D = listOf(listOf(-1F, 1F), listOf(2F, 0F), listOf(0F, 3F))
        val b: Matrix2D = listOf(listOf(3F, 1F, 2F), listOf(0F, -1F, 4F))
        val result: Matrix2D = listOf(listOf(-3F, -2F, 2F), listOf(6F, 2F, 4F), listOf(0F, -3F, 12F))
        assertEquals(result, (a * b))
    }
    
    @Test
    fun matrix2DTransposeEqualTest(){
        val a: Matrix2D = listOf(listOf(4F, 2F, 5F), listOf(9F, 0F, 6F))
        val result: Matrix2D = listOf(listOf(4F, 9F), listOf(2F, 0F), listOf(5F, 6F))
        assertEquals(result, a.transpose())
    }

    @Test
    fun matrix2DCrossVectorEqualTest(){
        val a: Matrix2D = listOf(listOf(2F, 4F, 0F), listOf(-2F, 1F, 3F), listOf(-1F, 0F, 1F))
        val b: Vector = listOf(1F, 2F, -1F)
        val result = listOf(listOf(10F), listOf(-3F), listOf(-2F))
        assertEquals(result, a crossVector b)
    }
}