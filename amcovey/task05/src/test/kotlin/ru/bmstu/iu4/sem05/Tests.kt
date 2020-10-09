package ru.bmstu.iu4.sem05

import org.junit.Test
import ru.bmstu.iu4.sem05.common.Canvas
import ru.bmstu.iu4.sem05.common.printPlot
import ru.bmstu.iu4.sem05.impl.Circle
import ru.bmstu.iu4.sem05.impl.Line
import ru.bmstu.iu4.sem05.impl.Point
import ru.bmstu.iu4.sem05.impl.Rectangle

class Tests {

    @Test
    fun drawPoint(){
        val testPoint = Point(3, 3)
        val myCanvas = Canvas(6, 6, 1).draw(listOf(testPoint))
        myCanvas.printPlot()
    }

    @Test
    fun drawLine(){
        val testLine1 = Line(Point(2,1), Point(5, 1))
        val testLine2 = Line(Point(10, 2), Point(10, 6))
        val testLine3 = Line(Point(0, 5), Point(5, 10))
        val myCanvas = Canvas(10, 10, 2).draw(listOf(testLine1, testLine2, testLine3))
        myCanvas.printPlot()
    }

    @Test
    fun drawRectangle(){
        val testRectangle = Rectangle(
            Point(35, 5),
            Point(50, 1),
            0
        )
        val myCanvas = Canvas(10, 30, 2).draw(listOf(testRectangle))
        myCanvas.printPlot()
    }

    @Test
    fun drawCircle(){
        val testCircle = Circle(Point(20, 10), 7, 12)
        val myCanvas = Canvas(10, 30, 2).draw(listOf(testCircle))
        myCanvas.printPlot()
    }

    @Test
    fun drawFigures(){
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
    }
}