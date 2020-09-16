package ru.bmstu.iu4.task02

import org.junit.Test
import ru.bmstu.iu4.task02.matrixFuncs.equals
import ru.bmstu.iu4.task02.matrixFuncs.minus
import ru.bmstu.iu4.task02.matrixFuncs.cross
import ru.bmstu.iu4.task02.matrixFuncs.plus
import ru.bmstu.iu4.task02.matrixFuncs.transpose
import ru.bmstu.iu4.task02.vectorFuncs.cross
import ru.bmstu.iu4.task02.vectorFuncs.equals
import ru.bmstu.iu4.task02.vectorFuncs.minus
import ru.bmstu.iu4.task02.vectorFuncs.plus
import ru.bmstu.iu4.task02.vectorFuncs.dot
import kotlin.test.assertEquals


internal class vecFuncsTest {

    @Test
    fun vecPlus() {
        val vec1: Vec = listOf(1.0, 2.5, 3.0)
        val vec2: Vec = listOf(1.0, 2.5, 3.0)
        val vecSum = vec1 + vec2
        val res: Vec = listOf(2.0, 5.0, 6.0)
        assertEquals(res, vecSum, "Plus Err")
    }

    @Test
    fun vecMinus() {
        val vec1: Vec = listOf(1.0, 2.5, 3.0)
        val vec2: Vec = listOf(1.0, 2.5, 3.0)
        val vecMin = vec1 - vec2
        val res: Vec = listOf(0.0, 0.0, 0.0)
        assertEquals(res, vecMin, "Minus Err")
    }

    @Test
    fun vecEqualsTrue() {
        val vec1: Vec = listOf(1.0, 2.5, 3.0)
        val vec2: Vec = listOf(1.0, 2.5, 3.0)
        val res = vec1 equals vec2
        assertEquals(true, res, "Equals True Err")
    }

    @Test
    fun vecEqualsFalse() {
        val vec1: Vec = listOf(1.0, 2.5, 3.0)
        val vec2: Vec = listOf(1.0, 1.5, 3.0)
        val res = vec1 equals vec2
        assertEquals(false, res, "Equals False Err")
    }

    @Test
    fun vecDot() {
        val vec1: Vec = listOf(1.0, 2.0, 3.0)
        val vec2: Vec = listOf(1.0, 1.0, 3.0)
        val res = vec1 dot vec2
        assertEquals(12.0, res, "Dot False Err")
    }

    @Test
    fun vecCross() {
        val vec1: Vec = listOf(1.0, 2.0, 3.0)
        val vec2: Vec = listOf(1.0, 2.0, 4.0)
        val res = listOf<Double>(2.0, -1.0, 0.0)

        assertEquals(res, vec1 cross vec2)
    }
}

internal class matFuncsTest {

    @Test
    fun matPlus() {
        val row: Vec = listOf(1.0, 2.0, 3.0)
        val mat: Mat = listOf(row, row, row)
        val matSum = mat + mat
        val res: Mat = listOf(listOf(2.0, 4.0, 6.0),
            listOf(2.0, 4.0, 6.0),
            listOf(2.0, 4.0, 6.0))

        assertEquals(res, matSum)
    }

    @Test
    fun matMinus() {
        val row: Vec = listOf(1.0, 2.0, 3.0)
        val mat: Mat = listOf(row, row, row)
        val matMin = mat - mat
        val res: Mat = listOf(listOf(0.0, 0.0, 0.0),
            listOf(0.0, 0.0, 0.0),
            listOf(0.0, 0.0, 0.0))

        assertEquals(res, matMin)
    }

    @Test
    fun matEqualsTrue() {
        val row: Vec = listOf(1.0, 2.0, 3.0)
        val mat1: Mat = listOf(row, row, row)
        val mat2: Mat = listOf(row, row, row)

        assertEquals(true, mat1 equals mat2)
    }

    @Test
    fun matEqualsFalse() {
        val row: Vec = listOf(1.0, 2.0, 3.0)
        val row1: Vec = listOf(1.0, 3.0, 3.0)
        val mat1: Mat = listOf(row, row, row)
        val mat2: Mat = listOf(row, row1, row)

        assertEquals(false, mat1 equals mat2)
    }

    @Test
    fun matTranspose(){
        val row: Vec = listOf(1.0, 2.0, 3.0)
        val mat: Mat = listOf(row, row, row)

        val row1: Vec = listOf(1.0, 1.0, 1.0)
        val row2: Vec = listOf(2.0, 2.0, 2.0)
        val row3: Vec = listOf(3.0, 3.0, 3.0)
        val matTr: Mat = listOf(row1, row2, row3)

        assertEquals(matTr, mat.transpose())
    }

    @Test
    fun matCross() {
        val row: Vec = listOf(1.0, 2.0, 3.0)
        val mat: Mat = listOf(row, row, row)

        val resMat: Mat = listOf(listOf(6.0, 12.0, 18.0),
            listOf(6.0, 12.0, 18.0),
            listOf(6.0, 12.0, 18.0))

        assertEquals(resMat, mat cross mat)
    }

    @Test
    fun matCrossVec() {
        val row: Vec = listOf(1.0, 2.0, 3.0)
        val mat: Mat = listOf(row, row, row)

        val resMat: Mat = listOf(listOf(14.0),
            listOf(14.0),
            listOf(14.0))

        assertEquals(resMat, mat cross row)
    }
}