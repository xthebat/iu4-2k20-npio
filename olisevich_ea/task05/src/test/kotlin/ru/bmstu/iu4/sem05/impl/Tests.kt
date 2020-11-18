package ru.bmstu.iu4.sem05.impl

import org.junit.Test
import ru.bmstu.iu4.sem05.common.Canvas
import ru.bmstu.iu4.sem05.common.toStr
import ru.bmstu.iu4.sem05.common.write
import kotlin.test.assertEquals

internal class Tests {

    @Test
    fun area() {
        val circle = Circle(Point(10.0, 20.0), 2.0, 1)
        assertEquals(12.566370614359172, circle.area())
    }

    @Test
    fun drawCircle() {
        val border = Rectangle(Point(0.0, 0.0), Point(19.0, 19.0), 1)
        val circle = Circle(Point(10.0, 10.0), 2.0, 1)
        val list = listOf(circle, border)
        val plot = Canvas(20, 20, 1).draw(list)

        val expected = """
            ********************
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *         *        *
            *       *   *      *
            *     *       *    *
            *       *   *      *
            *         *        *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            ********************
            
        """.trimIndent()

        assertEquals(expected, plot.toStr())
    }

    @Test
    fun drawLine() {
        val border = Rectangle(Point(0.0, 0.0), Point(19.0, 19.0), 1)
        val line = Line(Point(4.0, 5.0), Point(4.0, 10.0))
        val list = listOf(border, line)
        val plot = Canvas(20, 20, 1).draw(list)

        val expected = """
            ********************
            *                  *
            *                  *
            *                  *
            *                  *
            *   *              *
            *   *              *
            *   *              *
            *   *              *
            *   *              *
            *   *              *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            ********************
            
        """.trimIndent()

        assertEquals(expected, plot.toStr())

    }

    @Test
    fun drawPoint() {
        val border = Rectangle(Point(0.0, 0.0), Point(19.0, 19.0), 1)
        val point = Point(4.0, 4.0)
        val list = listOf(border, point)
        val plot = Canvas(20, 20, 1).draw(list)

        val expected = """
            ********************
            *                  *
            *                  *
            *                  *
            *   *              *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            *                  *
            ********************
            
        """.trimIndent()

        assertEquals(expected, plot.toStr())
    }

}