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
        TODO("Not yet implemented")
    }

    override fun print(writer: Writer) {
        writer.write(stringify())
    }

    init {
        require(lb.x < rt.x)
        require(lb.y < rt.y)

        println("Create: tag = $tag")
    }
}