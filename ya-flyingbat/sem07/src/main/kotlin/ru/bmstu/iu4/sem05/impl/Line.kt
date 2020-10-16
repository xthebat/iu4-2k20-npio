package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.common.Plot
import ru.bmstu.iu4.sem05.interfaces.Drawable
import kotlin.math.abs

class Line(val src: Point, val dst: Point) : Drawable {

    override fun draw(plot: Plot) {
        when {
            dst.y == src.y -> {
                val start = minOf(src.x, dst.x)
                val length = abs(dst.x - src.x)
                List(length) { Point(start + it, src.y) }
            }
            dst.x == src.x -> {
                val start = minOf(src.y, dst.y)
                val length = abs(dst.y - src.y)
                List(length) { Point(src.x, start + it) }
            }
            else -> {
                println("$this")
                val start = minOf(src.x, dst.x)
                val dx = dst.x - src.x
                val dy = dst.y - src.y
                require(abs(dx) == abs(dy)) { "Only diagonal slope lines supported" }
                val slope = dy / dx  // may be only +/- 1
                List(abs(dx)) { Point(start + it, it * slope + src.y) }
            }
        }.forEach { it.draw(plot) }
        src.draw(plot)
        dst.draw(plot)
    }

    override fun toString() = "$src -> $dst"
}