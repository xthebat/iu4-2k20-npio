package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.abstracts.AbstractFigure
import ru.bmstu.iu4.sem05.common.Plot
import java.io.Writer

class Circle(val center: Point, val radius: Double, tag: Int): AbstractFigure(tag) {
    override fun stringify() = "Circle(tag=$tag)"

    override fun area() = Math.PI * radius * radius

    override fun draw(plot: Plot) {
        TODO("Not yet implemented")
    }

    override fun print(writer: Writer) {
        writer.write(stringify())
    }
}