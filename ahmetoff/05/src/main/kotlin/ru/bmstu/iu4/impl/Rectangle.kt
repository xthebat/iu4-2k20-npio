package ru.bmstu.iu4.impl

import ru.bmstu.iu4.abstracts.AbstractFigure
import ru.bmstu.iu4.common.Plot
import java.io.Writer

class Rectangle(val lb: Point, val rt: Point, tag: Int) : AbstractFigure(tag) {

    val width get() = rt.x - lb.x
    val height get() = rt.y - lb.y

    override fun area() = width * height
    override fun stringify() = "Rectangle(tag=$tag)"

    override fun draw(plot: Plot) {
        for (stage in 0 until plot.size) {
            when (stage) {
                0 -> {
                    print("|")
                    plot[stage].forEach {
                        print("-")
                    }
                    println("|")
                    print("|")
                    print(plot[stage])
                    println("|")
                }
                plot.size - 1 -> {
                    print("|")
                    print(plot[stage])
                    println("|")
                    print("|")
                    plot[stage].forEach {
                        print("-")
                    }
                    println("|")
                }
                else -> {
                    print("|")
                    print(plot[stage])
                    println("|")
                }
            }
            //plot.forEach { print(it) }
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