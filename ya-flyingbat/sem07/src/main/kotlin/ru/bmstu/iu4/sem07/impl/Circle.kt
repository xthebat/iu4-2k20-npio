package ru.bmstu.iu4.sem07.impl

import ru.bmstu.iu4.sem07.abstracts.AbstractFigure
import ru.bmstu.iu4.sem07.common.Plot
import java.io.Writer
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin

class Circle(val center: Point, val radius: Int, tag: Int = 0) : AbstractFigure(tag) {

    constructor(x: Int, y: Int, radius: Int, tag: Int = 0) : this(Point(x, y), radius, tag)

    override fun stringify() = "Circle(tag=$tag)"

    override fun area(): Int = (Math.PI * radius * radius).toInt()

    override fun draw(plot: Plot) {
        listOf(
            Point(center.x, (center.y - radius)),
            Point((center.x - radius), center.y),
            symmetricalPoint(Point((center.x - radius), center.y), center),
            symmetricalPoint(Point(center.x, (center.y - radius)), center),
            center
        ).forEach { it.draw(plot) }

        if (radius > 1) {
            val step = 15.0
            val divisions = (360.0 / step).toInt()
            List(divisions + 1) {
                val angle = it * step
                val x = round(radius * cos(angle * Math.PI / 180)).toInt() + center.x
                val y = round(radius * sin(angle * Math.PI / 180)).toInt() + center.y
                Point(x, y)
            }.forEach { it.draw(plot) }
        }
    }

    override fun print(writer: Writer) {
        TODO("Not yet implemented")
    }

    private fun symmetricalPoint(point: Point, center: Point) = if (point.x == center.x) {
        Point(center.x, (2 * center.y - point.y))
    } else {
        Point((2 * center.x - point.x), center.y)
    }
}