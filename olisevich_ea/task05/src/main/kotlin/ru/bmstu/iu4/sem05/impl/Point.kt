package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.common.Plot
import ru.bmstu.iu4.sem05.interfaces.Drawable

class Point(val x: Double, val y: Double) : Drawable {
    override fun draw(plot: Plot, resolution: Int) {
        plot[x.toInt() * resolution][y.toInt() * resolution] = '*'
    }
}