package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.abstracts.AbstractFigure
import ru.bmstu.iu4.sem05.common.Plot
import java.io.Writer
import kotlin.math.*

class Circle(val center: Point, val radius: Double, tag: Int) : AbstractFigure(tag) {
    override fun stringify() = "Circle(tag=$tag)"

    override fun area() = Math.PI * radius * radius

    override fun draw(plot: Plot, resolution: Int) {
        var pointsCount = 8

        (0 until pointsCount).forEach {
            val x = (sin(2 * PI * it / pointsCount) * radius * resolution).toInt() + center.x * resolution
            val y = (cos(2 * PI * it / pointsCount) * radius * 2 * resolution).toInt() + center.y * resolution

            plot[x.toInt()][y.toInt()] = '*'
        }
    }

    override fun print(writer: Writer) {
        writer.write(stringify())
    }
}