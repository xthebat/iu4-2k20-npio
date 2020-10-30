package ru.bmstu.iu4.sem07

import ru.bmstu.iu4.sem07.common.Canvas
import ru.bmstu.iu4.sem07.common.print
import ru.bmstu.iu4.sem07.common.write
import ru.bmstu.iu4.sem07.impl.*
import java.io.File

object Starter {
    @JvmStatic
    fun main(args: Array<String>) {
        val figures = listOf(
                Line(Point(5, 10), Point(5, 16)),
                Line(Point(0, 0), Point(9, 15)),
                Line(Point(20, 20), Point(28, 28)),
                Rectangle(30, 2, 25, 20),
                Circle(80, 10, 7)
        )

        val canvas = Canvas(100, 30, 1).draw(figures).also { it.print() }
        File("output.txt").bufferedWriter().use { canvas.write(it) }
    }
}