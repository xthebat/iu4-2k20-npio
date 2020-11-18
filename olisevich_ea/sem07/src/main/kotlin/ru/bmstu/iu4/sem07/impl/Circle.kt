package ru.bmstu.iu4.sem07.impl

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.interfaces.AreaCalculateable
import ru.bmstu.iu4.sem07.interfaces.Drawable
import ru.bmstu.iu4.sem07.interfaces.Printable
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin

// http://gameprogrammingpatterns.com/component.html
// TODO: implement
class Circle(val center: Point, val radius: Int, val tag: Int = 0) : Entity() {

    constructor(x: Int, y: Int, radius: Int, tag: Int = 0) : this(Point(x, y), radius, tag)

    internal val drawer = Drawable { plot ->
        cache.forEach { it.drawer.draw(plot) }
    }

    internal val writer = Printable { writer ->
        writer.write("Circle(tag=$tag)\n")
    }

    internal val areaCalculator = AreaCalculateable {
        (Math.PI * radius * radius).toInt()
    }

    init {
        addComponent(drawer)
        addComponent(writer)
        addComponent(areaCalculator)
    }

    override fun toString() = "Circle(tag=$tag)"

    private val cache by lazy {
        Rectangle.log.fine { "Calculating circle markers: $this" }
        val tmp = mutableListOf(
                Point(center.x, (center.y - radius)),
                Point((center.x - radius), center.y),
                symmetricalPoint(Point((center.x - radius), center.y), center),
                symmetricalPoint(Point(center.x, (center.y - radius)), center),
                center
        )

        if (radius > 1) {
            val step = 15.0
            val divisions = (360.0 / step).toInt()
            repeat(divisions + 1) {
                val angle = it * step
                val x = round(radius * cos(angle * Math.PI / 180)).toInt() + center.x
                val y = round(radius * sin(angle * Math.PI / 180)).toInt() + center.y
                tmp.add(Point(x, y))
            }
        }

        tmp
    }

    private fun symmetricalPoint(point: Point, center: Point) = if (point.x == center.x) {
        Point(center.x, (2 * center.y - point.y))
    } else {
        Point((2 * center.x - point.x), center.y)
    }
}