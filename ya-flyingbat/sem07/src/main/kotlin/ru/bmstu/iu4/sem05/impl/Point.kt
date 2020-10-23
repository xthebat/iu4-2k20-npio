package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.common.Plot
import ru.bmstu.iu4.sem05.common.draw
import ru.bmstu.iu4.sem05.interfaces.Drawable
import ru.inforion.lab403.common.logging.logger

class Point(val x: Int, val y: Int) : Drawable {
    override fun draw(plot: Plot) = plot.draw(x, y, '*')

    override fun toString() = "($x, $y)"
}