package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.abstracts.AbstractFigure
import ru.bmstu.iu4.sem05.common.Plot
import java.io.Writer

class Circle(val center: Point, val radius: Double, tag: Int): AbstractFigure(tag) {
    override fun stringify() = "Circle(tag=$tag)"

    override fun area() = Math.PI * radius * radius

    override fun draw(plot: Plot) {
        Point(center.x, center.y).draw(plot)

        Line(Point(center.x, center.y - radius), Point(center.x - radius, center.y)).draw(plot)
        Line(Point(center.x - radius, center.y), Point(center.x, center.y + radius)).draw(plot)
        Line(Point(center.x, center.y + radius), Point(center.x + radius, center.y)).draw(plot)
        Line(Point(center.x + radius, center.y), Point(center.x, center.y - radius)).draw(plot)
    }

    override fun print(writer: Writer) {
        writer.write(stringify())
    }
}