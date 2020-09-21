package ru.bmstu.iu4.task02

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails


internal class T2funcsKtTest {

    @Test
    fun matrixOf() {
        val expected: Matrix = arrayListOf(arrayListOf(1F, 2F), arrayListOf(3F, 4F));
        val actual: Matrix = matrixOf(listOf("1 2", "3 4"));
        assertEquals(expected, actual);
    }

    @Test
    fun Matrix2DCrossCompareConsistent() {
        val testmat: Matrix2D = matrixOf(listOf("1 2", "3 4"));
        val testmat1: Matrix = matrixOf(listOf("2 3 2", "4 1 2"));
        assertFails { testmat cross testmat1 };
    }

    @Test
    fun Matrix2DCrosstMatrix2D(){
        var testmat: Matrix2D = matrixOf(listOf("1 2", "3 4"))
        val testmat1: Matrix2D = matrixOf(listOf("2 3", "4 1"))
        assertEquals( matrixOf(listOf("11 16", "7 12")),testmat cross testmat1);
    }

    @Test
    fun MatrixTranspose(){
        var testmat: Matrix = matrixOf(listOf("1 2", "3 4"))
        assertEquals(matrixOf(listOf("1 3", "2 4")), testmat.transpose())
    }

    @Test
    fun MatrixDotMatrix(){
        var testmat: Matrix = matrixOf(listOf("1 2", "3 4"))
        assertEquals(matrixOf(listOf("1 4", "9 16")), testmat dot testmat)
    }


    @Test
    fun MatrixOperatorPlusMatrix() {
        val testmat: Matrix = matrixOf(listOf("1 2", "3 4"));
        val testmat1: Matrix = matrixOf(listOf("2 3", "4 1"));
        val expected: Matrix = matrixOf(listOf("3 5", "7 5"));
        val actual: Matrix = testmat+testmat1;
        assertEquals(expected, actual);
    }

    @Test
    fun MatrixOperatorPlusFloat() {
        val testmat: Matrix = matrixOf(listOf("1 2", "3 4"));
        val f: Float = 10F;
        val expected: Matrix = matrixOf(listOf("11 12", "13 14"));
        val actual: Matrix = testmat+f;
        assertEquals(expected, actual);
    }

    @Test
    fun MatrixOperatorMinusMatrix() {
        val testmat: Matrix = matrixOf(listOf("1 2", "3 4"));
        val testmat1: Matrix = matrixOf(listOf("2 3", "4 1"));
        val expected: Matrix = matrixOf(listOf("1 1", "1 -3"));
        val actual: Matrix = testmat1-testmat;
        assertEquals(expected, actual);
    }

    @Test
    fun MatrixOperatorMinusFloat() {
        val testmat: Matrix = matrixOf(listOf("1 2", "3 4"));
        val f: Float = 1F;
        val expected: Matrix = matrixOf(listOf("0 1", "2 3"));
        val actual: Matrix = testmat - f;
        assertEquals(expected, actual);
    }

    @Test
    fun MatrixOperatorTimesMatrix() {
        val testmat: Matrix = matrixOf(listOf("1 2", "3 4"));
        val testmat1: Matrix = matrixOf(listOf("2 3", "4 1"));
        val expected: Matrix = matrixOf(listOf("2 6", "12 4"));
        val actual: Matrix = testmat * testmat1;
        assertEquals(expected, actual);
    }


    @Test
    fun MatrixOperatorTimesFloat() {
        val testmat: Matrix = matrixOf(listOf("1 2", "3 4"));
        val f: Float = 2F;
        val expected: Matrix = matrixOf(listOf("2 4", "6 8"));
        val actual: Matrix = testmat * f;
        assertEquals(expected, actual);
    }



}