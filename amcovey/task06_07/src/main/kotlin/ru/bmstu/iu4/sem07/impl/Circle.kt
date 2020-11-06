package ru.bmstu.iu4.sem07.impl

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.common.Plot
import ru.bmstu.iu4.sem07.interfaces.AreaCalculateable
import ru.bmstu.iu4.sem07.interfaces.Drawable
import ru.bmstu.iu4.sem07.interfaces.Printable
import java.io.Writer
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin

// http://gameprogrammingpatterns.com/component.html
// TODO: implement
class Circle(val center: Point, val radius: Int, tag: Int = 0) : Entity() {

    constructor(x: Int, y: Int, radius: Int, tag: Int = 0) : this(Point(x, y), radius, tag)

    private val drawer = Drawable { plot ->
        cache.forEach { it.drawer.draw(plot) }
    }

    internal val writer = Printable { writer ->
        writer.write("Circle center: ($center), radius: $radius\n")
    }

    internal val area = AreaCalculateable {
        (Math.PI * radius * radius).toInt()
    }

    init {
        addComponent(drawer)
        addComponent(writer)
        addComponent(area)
    }

    private val cache by lazy {
        val circlePoints = mutableListOf(
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
                circlePoints.add(Point(x, y))
            }
        }

        circlePoints
    }

    private fun symmetricalPoint(point: Point, center: Point) = if (point.x == center.x) {
        Point(center.x, (2 * center.y - point.y))
    } else {
        Point((2 * center.x - point.x), center.y)
    }
}