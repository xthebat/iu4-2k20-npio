package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.abstracts.AbstractFigure
import ru.bmstu.iu4.sem05.common.Plot
import java.io.Writer

class Rectangle(val lb: Point, val rt: Point, tag: Int = 0): AbstractFigure(tag) {

    constructor(x: Int, y: Int, width: Int, height: Int, tag: Int = 0) :
            this(Point(x, y), Point(x + width, y + height), tag)

    val width get() = rt.x - lb.x
    val height get() = rt.y - lb.y

    override fun area(): Int = width * height

    override fun stringify() = "Rectangle(tag=$tag)"

    override fun draw(plot: Plot) {
        val lt = Point(lb.x, rt.y)
        val rb = Point(rt.x, lb.y)
        listOf(Line(lb, lt), Line(lt, rt), Line(rt, rb), Line(rb, lb), ).forEach { it.draw(plot) }
    }

    override fun print(writer: Writer) {
        writer.write(stringify())
    }

    override fun toString() = "[$lb, $rt]"

    init {
        require(lb.x < rt.x) { "$lb < $rt" }
        require(lb.y < rt.y) { "$lb < $rt" }
    }
}