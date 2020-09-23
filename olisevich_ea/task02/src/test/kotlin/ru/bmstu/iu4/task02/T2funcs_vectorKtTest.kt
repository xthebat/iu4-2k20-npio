package ru.bmstu.iu4.task02

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

internal class T2funcs_vectorKtTest {

    @Test
    fun vectorOf() {
        val actual: VectorCol = vectorOf("1 2 3")
        val expected: VectorCol = arrayListOf(1F, 2F, 3F);
        assertEquals(expected, actual)
    }

    @Test
    fun vectorDotvector() {
        val v: Vector = vectorOf("1 2 3");
        val v1: Vector = vectorOf( "1 2 3");
        assertEquals(14F, v dot v1)
    }

    @Test
    fun vectorColDotMatrix() {
        var testmat: Matrix = matrixOf(listOf("1 2", "3 4"))
        val v2: VectorCol = vectorOf("1 2");
        assertEquals(vectorOf("4 12"), v2 crossmc testmat )

    }

    @Test
    fun vectorColDotMatrixCompare() {
        var testmat: Matrix = matrixOf(listOf("1 2", "3 4"))
        val v2: VectorCol = vectorOf("1 2 3");
        assertFails { v2 crossmc testmat }

    }

    @Test
    fun vectorStrDotMatrix() {
        var testmat: Matrix = matrixOf(listOf("1 2"))
        val v2: VectorCol = vectorOf("1 2");
        assertEquals(matrixOf(listOf("1 2", "2 4")), v2 crossms testmat )

    }

    @Test
    fun vectorStrDotMatrixCompare() {
        val testmat: Matrix = matrixOf(listOf("1 2 3", "3 4"))
        val v2: VectorCol = vectorOf("1 2");
        assertFails { v2 crossmc testmat }

    }

    @Test
    fun vectorOperatorPlusVector() {
        assertEquals(vectorOf("2 4"), vectorOf("1 2") + vectorOf("1 2"))
    }

    @Test
    fun vectorOperatorPlusFloat() {
        assertEquals(vectorOf("2 3"), vectorOf("1 2") + 1F)

    }

    @Test
    fun vectorOperatorMinusVector() {
        assertEquals(vectorOf("0 0"), vectorOf("1 2") - vectorOf("1 2"))
    }

    @Test
    fun vectorOperatorMinusFloat() {
        assertEquals(vectorOf("0 1"), vectorOf("1 2") - 1F)
    }

    @Test
    fun vectorOperatorTimesVector() {
        assertEquals(vectorOf("1 4"), vectorOf("1 2") * vectorOf("1 2"))
    }

    @Test
    fun vectorOperatorTimesFloat() {
        assertEquals(vectorOf("2 4"), vectorOf("1 2") * 2F)

    }




}