package ru.bmstu.iu4.impl

import ru.bmstu.iu4.interfaces.Drawable
import ru.bmstu.iu4.common.Plot

class Point(val x: Double, val y: Double): Drawable {
    var sym = '*'

    override fun draw(plot: Plot) {
        plot[y.toInt() - 1][x.toInt() - 1] = sym
    }
}