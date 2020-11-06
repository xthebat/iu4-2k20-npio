package ru.bmstu.iu4.sem07.builders

import ru.bmstu.iu4.sem07.impl.Point
import ru.bmstu.iu4.sem07.interfaces.EntityBuilder

// https://en.wikipedia.org/wiki/Builder_pattern
class JavaPointEntityBuilder : EntityBuilder {
    private var x: Int = 0
    private var y: Int = 0

    fun setX(newX: Int) = apply { x = newX }

    fun setY(newY: Int) = apply { y = newY }

    override fun build() = Point(x, y)
}