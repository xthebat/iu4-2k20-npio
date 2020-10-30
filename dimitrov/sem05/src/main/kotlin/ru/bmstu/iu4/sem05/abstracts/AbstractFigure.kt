package ru.bmstu.iu4.sem05.abstracts

import ru.bmstu.iu4.sem05.interfaces.Drawable
import ru.bmstu.iu4.sem05.interfaces.Printable

abstract class AbstractFigure(var tag: Int): Drawable, Printable {
    open fun stringify() = "Figure(tag=$tag)"

    abstract fun area(): Double
}