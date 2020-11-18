package ru.bmstu.iu4.sem05

import ru.bmstu.iu4.sem05.common.Canvas
import ru.bmstu.iu4.sem05.common.printPlot
import ru.bmstu.iu4.sem05.common.write
import ru.bmstu.iu4.sem05.impl.*

import java.io.File

object Starter {

    @JvmStatic
    fun main(args: Array<String>) {

        val myFirstLine = Line(Point(34, 10), Point(34, 16))
        val mySecondLine = Line(Point(0, 0), Point(10, 10))
        val myRectangle = Rectangle(
            Point(35, 5),
            Point(50, 1),
            0
        )
        val myCircle = Circle(Point(20, 10), 7, 12)
        val figures = listOf(myFirstLine, mySecondLine, myCircle,myRectangle)
        val myCanvas = Canvas(10, 30, 2).draw(figures)
        myCanvas.printPlot()
        val writer = File("output.txt").bufferedWriter()
        myCanvas.write(writer)
        writer.close()
    }
}