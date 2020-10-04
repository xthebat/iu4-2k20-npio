package ru.bmstu.iu4.impl

import ru.bmstu.iu4.abstracts.AbstractFigure
import ru.bmstu.iu4.common.Plot
import java.io.Writer

class Circle(val center: Point, val radius: Double, tag: Int) : AbstractFigure(tag) {
    override fun area() = Math.PI * radius * radius
    override fun stringify() = "Circle(tag=$tag)"

    override fun draw(plot: Plot) {
        if ((radius % 2).equals(0) == false) {
            var stage = 0
            for (i in 0 until (radius/2).toInt()) {
                plot[i][((radius/2).toInt()) + stage] = '*'
                plot[i][((radius/2).toInt()) - stage] = '*'
                println(plot[i])
                stage = stage + 1
            }
            for (i in ((radius/2).toInt() + 1) until radius.toInt() + 1) {
                plot[i][((radius/2).toInt()) + stage] = '*'
                plot[i][((radius/2).toInt()) - stage] = '*'
                println(plot[i])
                stage = stage - 1
            }
        }
    }

    override fun print(writer: Writer) {
        writer.write(stringify())
    }
}