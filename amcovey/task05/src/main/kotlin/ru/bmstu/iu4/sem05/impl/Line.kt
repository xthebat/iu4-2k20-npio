package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.common.Plot
import ru.bmstu.iu4.sem05.interfaces.Drawable
import kotlin.math.abs

class Line(val src: Point, val dst: Point) : Drawable {

    override fun draw(plot: Plot) {
        src.draw(plot)
        dst.draw(plot)
        val interPoints = mutableListOf<Point>()
        when {
            dst.y == src.y -> {
                for (xPoint in src.x + 1 until dst.x)
                    interPoints.add(Point(xPoint, src.y))
            }
            dst.x == src.x -> {
                for (yPoint in src.y + 1 until dst.y)
                    interPoints.add(Point(src.x, yPoint))
            }
            else -> {
                require(abs(dst.x - src.x) == abs(dst.y - src.y))
                val slopeRatio = (dst.y - src.y) / (dst.x - src.x)
                val displace = src.y
                for (xPoint in src.x + 1 until dst.x){
                    interPoints.add(Point(xPoint, xPoint * slopeRatio + displace))
                }
            }
        }

        interPoints.forEach { it.draw(plot) }
    }
}