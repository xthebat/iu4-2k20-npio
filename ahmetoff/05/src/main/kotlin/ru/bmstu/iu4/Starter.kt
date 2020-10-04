package ru.bmstu.iu4

import ru.bmstu.iu4.abstracts.AbstractFigure
import ru.bmstu.iu4.common.Canvas
import ru.bmstu.iu4.common.plot
import ru.bmstu.iu4.common.write
import ru.bmstu.iu4.impl.*

object Starter {
    @JvmStatic
    fun main(args: Array<String>) {
        val rectangle = Rectangle(Point(10.0, 20.0), Point(20.0, 30.0), 0)
        val circle = Circle(Point(10.0, 20.0), 7.0, 1)

        // val list = listOf<AbstractFigure>(rectangle, circle).forEach {
        //    println(it.stringify())
        //    println(it.area())
        //}

        val list = listOf(rectangle, circle, Point(10.0, 20.0))
        val plot = Canvas(15, 15, 2).draw(list)

        plot.write(System.out.writer())
    }
}