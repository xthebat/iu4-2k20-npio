package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.common.Plot
import ru.bmstu.iu4.sem05.interfaces.Drawable
import kotlin.math.pow
import kotlin.math.sqrt

class Line(val src: Point, val dst: Point) : Drawable {
    override fun draw(plot: Plot, resolution: Int) {
        if (src.y == dst.y) {
            val x = dst.x.toInt() * resolution
            val dx = src.x.toInt() * resolution
            val r = x.coerceAtLeast(dx) downTo x.coerceAtMost(dx)

            r.forEach { plot[dst.y.toInt() * resolution][it] = '*' }

        } else if (src.x == dst.x) {
            val y = dst.y.toInt() * resolution
            val dy = src.y.toInt() * resolution
            val r = y.coerceAtLeast(dy) downTo y.coerceAtMost(dy)

            r.forEach { plot[it][dst.x.toInt() * resolution] = '*' }
        }

    }
}