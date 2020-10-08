package ru.bmstu.iu4.sem05.impl

import org.junit.Test
import ru.bmstu.iu4.sem05.common.Canvas
import ru.bmstu.iu4.sem05.common.write
import kotlin.test.assertEquals

internal class CircleTest {

    @Test
    fun area() {
        val circle = Circle(Point(10.0, 20.0), 2.0, 1)
        assertEquals(12.566370614359172, circle.area())
    }

    @Test
    fun draw() {
        val rectangle = Rectangle(Point(0.0, 0.0), Point(19.0, 19.0), 1)
        val circle = Circle(Point(10.0, 10.0), 2.0, 1)
        val list = listOf(circle, rectangle)
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

        TODO("Override toString method for tests..")
    }
}