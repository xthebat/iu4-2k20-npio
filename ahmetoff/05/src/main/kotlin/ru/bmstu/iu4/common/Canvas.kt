package ru.bmstu.iu4.common

import ru.bmstu.iu4.interfaces.Drawable

class Canvas(val width: Int, val height: Int, val resolution: Int) {
    fun draw(elements: Collection<Drawable>) = plot(width, height).also {
        elements.forEach {
            e->e.draw(it)
        }
    }
}