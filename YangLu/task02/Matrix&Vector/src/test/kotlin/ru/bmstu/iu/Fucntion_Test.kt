package ru.bmstu.iu
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.bmstu.iu4.Matrix
import ru.bmstu.iu4.Vector


internal class MatrixTest {

    @Test
    fun testVectorMultiplication(){

        val vec = Vector(2.0, 1.0, 0.0)

        val mat = Matrix(2, 3)
        mat.setRow(0, 1.0, -1.0, 2.0)
        mat.setRow(1, 0.0, -3.0, 1.0)

        val result = mat * vec
        val expected = Vector(1.0, -3.0)
        assertEquals(expected, result)
    }

    @Test
    fun testMultiply() {
        val v = Vector(1.0, 2.0, 3.0)
        val w = Matrix(2, 3)
        w.setRow(0, 2.0, 3.0, 4.0)
        w.setRow(1, 3.0, 4.0, 5.0)
        val result = w * v
        assertEquals(Vector(20.0, 26.0), result)
    }


    @Test
    fun testMultiply2() {
        val v = Vector(1.0, 2.0)
        val w = Matrix(2, 3)
        w.setRow(0, 2.0, 1.0, 3.0)
        w.setRow(1, 3.0, 4.0, -1.0)
        val result = v * w
        assertEquals(Vector(8.0, 9.0, 1.0), result)
    }

    @Test
    fun unaryOps(){
        val w = Matrix(2, 3)
        w.setRow(0, 2.0, 1.0, 3.0)
        w.setRow(1, 3.0, 4.0, -1.0)
        val v = Matrix(2, 3)
        v.setRow(0, 2.0, 1.0, 3.0)
        v.setRow(1, 3.0, 4.0, -1.0)

        val d = w + v
        w += v

        assertEquals(d, w)
    }
}