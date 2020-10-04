package ru.bmstu.iu4.impl

import ru.bmstu.iu4.interfaces.Drawable
import ru.bmstu.iu4.common.Plot

class Point(val x: Double, val y: Double): Drawable {
    override fun draw(plot: Plot) {
        println("*")
    }
}