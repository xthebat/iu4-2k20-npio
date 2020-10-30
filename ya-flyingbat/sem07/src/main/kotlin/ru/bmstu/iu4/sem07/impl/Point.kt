package ru.bmstu.iu4.sem07.impl

import ru.bmstu.iu4.sem07.common.Plot
import ru.bmstu.iu4.sem07.common.draw
import ru.bmstu.iu4.sem07.interfaces.Drawable

class Point(val x: Int, val y: Int) : Drawable {
    override fun draw(plot: Plot) = plot.draw(x, y, '*')

    override fun toString() = "($x, $y)"
}