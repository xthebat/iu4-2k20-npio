package ru.bmstu.iu4

import org.junit.Test

internal class Tests {
    @Test
    fun testSumm() {
        val rows1 = 3
        val cols1 = 3

        val matrix1: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix1.init()
        matrix1.print()
        println()

        val matrix2: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix2.init()
        matrix2.print()
        println()

        val matrix3: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix3.summ(matrix1, matrix2)
        matrix3.print()
        println()
    }

    @Test
    fun testSubtr() {
        val rows1 = 3
        val cols1 = 3

        val matrix1: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix1.init()
        matrix1.print()
        println()

        val matrix2: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix2.init()
        matrix2.print()
        println()

        val matrix3: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix3.subtr(matrix1, matrix2)
        matrix3.print()
        println()
    }

    @Test
    fun testDotMult() {
        val rows1 = 3
        val cols1 = 3

        val matrix1: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix1.init()
        matrix1.print()
        println()

        val matrix2: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix2.init()
        matrix2.print()
        println()

        val matrix3: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix3.dotMult(matrix1, matrix2)
        matrix3.print()
        println()
    }

    @Test
    fun testCrossMult() {
        val rows1 = 3
        val cols1 = 2
        val rows2 = 2
        val cols2 = 3

        val matrix1: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix1.init()
        matrix1.print()
        println()

        val matrix2: Matrix = MutableList(rows2, { MutableList(cols2, { 0 }) })
        matrix2.init()
        matrix2.print()
        println()

        val matrix3: Matrix = MutableList(rows1, { MutableList(cols2, { 0 }) })
        matrix3.crossMult(matrix1, matrix2)
        matrix3.print()
        println()
    }

    @Test
    fun testTransp() {
        val rows1 = 3
        val cols1 = 2

        val matrix1: Matrix = MutableList(rows1, { MutableList(cols1, { 0 }) })
        matrix1.init()
        matrix1.print()
        println()

        val matrix2: Matrix = matrix1.transp()
        matrix2.print()
        println()
    }
}