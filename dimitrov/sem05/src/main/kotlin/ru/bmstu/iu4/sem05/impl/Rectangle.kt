package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.abstracts.AbstractFigure
import ru.bmstu.iu4.sem05.common.Plot
import java.io.Writer

class Rectangle(val lb: Point, val rt: Point, tag: Int): AbstractFigure(tag) {

    val width get() = rt.x - lb.x
    val height get() = rt.y - lb.y

    override fun area() = width * height

    override fun stringify() = "Rectangle(tag=$tag)"

    override fun draw(plot: Plot) {
        Line(Point(lb.x, lb.y), Point(lb.x, rt.y)).draw(plot)
        Line(Point(lb.x, lb.y), Point(rt.x, lb.y)).draw(plot)
        Line(Point(lb.x, rt.y), Point(rt.x, rt.y)).draw(plot)
        Line(Point(rt.x, lb.y), Point(rt.x, rt.y)).draw(plot)
    }

    override fun print(writer: Writer) {
        writer.write(stringify())
    }

    init {
        require(lb.x < rt.x)
        require(lb.y < rt.y)
    }
}