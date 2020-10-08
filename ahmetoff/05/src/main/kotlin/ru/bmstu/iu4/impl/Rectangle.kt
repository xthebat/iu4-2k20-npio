package ru.bmstu.iu4.impl

import ru.bmstu.iu4.abstracts.AbstractFigure
import ru.bmstu.iu4.common.Plot
import java.io.Writer

class Rectangle(val lb: Point, val rt: Point, tag: Int) : AbstractFigure(tag) {
    var border = '*'
    val width get() = rt.x - lb.x
    val height get() = rt.y - lb.y

    override fun area() = width * height
    override fun stringify() = "Rectangle(tag=$tag)"

    override fun draw(plot: Plot) {
        for (i in 0 until  height.toInt()) {
            for (j in 0 until width.toInt()) {
                if (i == 0 || i == height.toInt() - 1) {
                    plot[lb.y.toInt() + i - 1][lb.x.toInt() + j - 1] = border
                }
                else {
                    if (j == 0 || j == width.toInt() - 1) {
                        plot[lb.y.toInt() + i - 1][lb.x.toInt() + j - 1] = border
                    }
                    else {
                        plot[lb.y.toInt() + i - 1][lb.x.toInt() + j - 1] = ' '
                    }
                }
            }
        }
    }

    override fun print(writer: Writer) {
        writer.write(stringify())
    }

    init {
        require(lb.x < rt.x)
        require(lb.y < rt.y)
    }
}