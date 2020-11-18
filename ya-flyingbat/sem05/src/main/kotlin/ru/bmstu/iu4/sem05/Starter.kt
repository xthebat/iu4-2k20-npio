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
        val rectangle = Rectangle(Point(10.0, 20.0), Point(20.0, 30.0), 0)
        val circle = Circle(Point(10.0, 20.0), 10.0, 1)

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

        val list = listOf(rectangle, circle, Point(10.0, 20.0))
        val plot = Canvas(100, 200, 10).draw(list)

        plot.write(System.out.writer())
    }
}