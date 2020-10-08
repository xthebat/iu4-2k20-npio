package ru.bmstu.iu4.sem05

import ru.bmstu.iu4.sem05.abstracts.AbstractFigure
import ru.bmstu.iu4.sem05.common.Canvas
import ru.bmstu.iu4.sem05.common.write
import ru.bmstu.iu4.sem05.impl.*
import ru.inforion.lab403.common.logging.logger

object Starter {
    val log = logger()

    fun totalArea(figures: Collection<AbstractFigure>) = figures.sumByDouble { it.area() }

    @JvmStatic
    fun main(args: Array<String>) {

        val canvasWidth = 40
        val canvasHeigth = 25

        val rectangle = Rectangle(Point(0.0, 0.0), Point(canvasWidth.toDouble() - 1, canvasHeigth.toDouble() - 1), 0)
        val circle = Circle(Point(10.0, 20.0), 2.0, 1)

        val figures = listOf(rectangle, circle).onEach {
            log.warning { "stringify($it) -> ${it.stringify()} area = ${it.area()}" }
            when (it) {
                is Rectangle -> log.info { "Rectangle(tag = ${it.tag})" }
                is Circle -> log.info { "Circle(tag = ${it.tag})" }
                else -> log.info { "Figure(tag = ${it.tag})" }
            }
        }

        log.fine { "rectangle = ${rectangle.stringify()}" }
        log.fine { "circle = ${circle.stringify()}" }

        log.info { "total area = ${totalArea(figures)}" }

        val list = listOf(Point(20.0, 10.0), Line(Point(10.0, 10.0), Point(10.0, 15.0)), rectangle, circle)
        val plot = Canvas(canvasWidth, canvasHeigth, 2).draw(list)

        plot.write(System.out.writer())
    }
}