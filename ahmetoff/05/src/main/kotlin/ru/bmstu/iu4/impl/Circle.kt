package ru.bmstu.iu4.impl

import ru.bmstu.iu4.abstracts.AbstractFigure
import ru.bmstu.iu4.common.Plot
import java.io.Writer

class Circle(val center: Point, val radius: Double, tag: Int) : AbstractFigure(tag) {
    var border = '*'

    override fun area() = Math.PI * radius * radius
    override fun stringify() = "Circle(tag=$tag)"

    override fun draw(plot: Plot) {
        for (i in 0 until radius.toInt()) {
            for (j in 0 until radius.toInt() - i) {
                if (j == radius.toInt() - i - 1) {
                    plot[center.y.toInt() + i][center.y.toInt() + j] = border
                    plot[center.y.toInt() + i][center.y.toInt() - j] = border
                    plot[center.y.toInt() - i][center.y.toInt() + j] = border
                    plot[center.y.toInt() - i][center.y.toInt() - j] = border
                }
            }
        }
    }

    override fun print(writer: Writer) {
        writer.write(stringify())
    }
}