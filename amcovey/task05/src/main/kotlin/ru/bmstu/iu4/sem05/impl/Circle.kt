package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.abstracts.AbstractFigure
import ru.bmstu.iu4.sem05.common.Plot
import ru.inforion.lab403.common.extensions.collect
import java.io.Writer
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin

class Circle(val center: Point, val radius: Int, tag: Int) : AbstractFigure(tag) {
    override fun stringify() = "Circle(tag=$tag)"

    override fun area(): Int = (Math.PI * radius * radius).toInt()

    override fun draw(plot: Plot) {
        val circlePoints = mutableListOf(
            Point(center.x, (center.y - radius)),
            Point((center.x - radius), center.y),
            symmetricalPoint(Point((center.x - radius), center.y), center),
            symmetricalPoint(Point(center.x, (center.y - radius)), center),
            center
        )
        if (radius > 1) {
            val angle = 30.0
            val divisions = (360.0 / angle).toInt()
            val angles = mutableListOf<Double>()
            collect(divisions + 1){
                angles.add(it * angle)
            }
            angles.forEach {
                circlePoints.add(Point(round(radius * cos(it * Math.PI / 180)).toInt() + center.x,
                    round(radius * sin(it * Math.PI / 180)).toInt() + center.y))
            }
        }

        circlePoints.forEach { it.draw(plot) }

    }

    override fun print(writer: Writer) {
        TODO("Not yet implemented")
    }

    private fun symmetricalPoint(point: Point, center: Point): Point {
        return if (point.x == center.x) {
            Point(center.x, (2 * center.y - point.y))
        } else {
            Point((2 * center.x - point.x), center.y)
        }
    }
}