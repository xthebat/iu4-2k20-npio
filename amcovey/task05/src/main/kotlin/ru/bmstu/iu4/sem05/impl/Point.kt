package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.common.Plot
import ru.bmstu.iu4.sem05.interfaces.Drawable

class Point(val x: Int, val y: Int) : Drawable {
    override fun draw(plot: Plot) {
        plot[y][x] = '*'
    }
}