package ru.bmstu.iu4.sem05

import org.junit.Test
import ru.bmstu.iu4.sem05.common.Canvas
import ru.bmstu.iu4.sem05.common.Plot
import ru.bmstu.iu4.sem05.common.printPlot
import ru.bmstu.iu4.sem05.impl.Circle
import ru.bmstu.iu4.sem05.impl.Line
import ru.bmstu.iu4.sem05.impl.Point
import ru.bmstu.iu4.sem05.impl.Rectangle
import ru.inforion.lab403.common.logging.logger
import java.lang.StringBuilder
import kotlin.math.exp
import kotlin.test.assertEquals

class Tests {
    val log = logger()

    fun Plot.convertCanvasToString(): String{
        val result = StringBuilder()
        forEach {
            result.append(it.joinToString("", postfix = "\n"))
        }
        return result.toString()
    }

    @Test
    fun drawPoint(){
        val testPoint = Point(3, 3)
        val myCanvas = Canvas(6, 6, 1).draw(listOf(testPoint))
        val result = myCanvas.convertCanvasToString()
        log.info { "\n${result}" }
        val expected =  "******\n" +
                        "*    *\n" +
                        "*    *\n" +
                        "*  * *\n" +
                        "*    *\n" +
                        "******\n"

        assertEquals(expected, result)

    }

    @Test
    fun drawLine(){
        val testLine1 = Line(Point(2,1), Point(5, 1))
        val testLine2 = Line(Point(10, 2), Point(10, 6))
        val testLine3 = Line(Point(0, 5), Point(5, 10))
        val myCanvas = Canvas(10, 10, 2).draw(listOf(testLine1, testLine2, testLine3))
        val result = myCanvas.convertCanvasToString()
        log.info { "\n$result" }
        val expected =  "********************\n" +
                        "* ****             *\n" +
                        "*         *        *\n" +
                        "*         *        *\n" +
                        "*         *        *\n" +
                        "*         *        *\n" +
                        "**        *        *\n" +
                        "* *                *\n" +
                        "*  *               *\n" +
                        "*   *              *\n" +
                        "*    *             *\n" +
                        "*                  *\n" +
                        "*                  *\n" +
                        "*                  *\n" +
                        "*                  *\n" +
                        "*                  *\n" +
                        "*                  *\n" +
                        "*                  *\n" +
                        "*                  *\n" +
                        "********************\n"
        assertEquals(expected, result)
    }

    @Test
    fun drawRectangle(){
        val testRectangle = Rectangle(
            Point(35, 5),
            Point(50, 1),
            0
        )
        val myCanvas = Canvas(10, 30, 2).draw(listOf(testRectangle))
        val result = myCanvas.convertCanvasToString()
        log.info { "\n$result" }
        val expected =  "************************************************************\n" +
                        "*                                  ****************        *\n" +
                        "*                                  *              *        *\n" +
                        "*                                  *              *        *\n" +
                        "*                                  *              *        *\n" +
                        "*                                  ****************        *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "************************************************************\n"
        assertEquals(expected, result)
    }

    @Test
    fun drawCircle(){
        val testCircle = Circle(Point(20, 10), 7, 12)
        val myCanvas = Canvas(10, 30, 2).draw(listOf(testCircle))
        val result = myCanvas.convertCanvasToString()
        log.info { "\n$result" }
        val expected =  "************************************************************\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                   *                                      *\n" +
                        "*               *       *                                  *\n" +
                        "*                                                          *\n" +
                        "*             *           *                                *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*            *      *      *                               *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*             *           *                                *\n" +
                        "*                                                          *\n" +
                        "*                                                          *\n" +
                        "*                *      *                                  *\n" +
                        "*                   *                                      *\n" +
                        "*                                                          *\n" +
                        "************************************************************\n"
        assertEquals(expected, result)
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
        val result = myCanvas.convertCanvasToString()
        log.info { "\n$result" }
        val expected =  "************************************************************\n" +
                        "**                                 ****************        *\n" +
                        "* *                                *              *        *\n" +
                        "*  *                *              *              *        *\n" +
                        "*   *           *       *          *              *        *\n" +
                        "*    *                             ****************        *\n" +
                        "*     *       *           *                                *\n" +
                        "*      *                                                   *\n" +
                        "*       *                                                  *\n" +
                        "*        *                                                 *\n" +
                        "*         *  *      *      *      *                        *\n" +
                        "*                                 *                        *\n" +
                        "*                                 *                        *\n" +
                        "*             *           *       *                        *\n" +
                        "*                                 *                        *\n" +
                        "*                                 *                        *\n" +
                        "*                *      *         *                        *\n" +
                        "*                   *                                      *\n" +
                        "*                                                          *\n" +
                        "************************************************************\n"
        assertEquals(expected, result)
    }
}