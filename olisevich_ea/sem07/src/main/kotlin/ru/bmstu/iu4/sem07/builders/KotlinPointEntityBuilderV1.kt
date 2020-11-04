package ru.bmstu.iu4.sem07.builders

import ru.bmstu.iu4.sem07.impl.Point
import ru.bmstu.iu4.sem07.interfaces.EntityBuilder

// https://en.wikipedia.org/wiki/Builder_pattern
class KotlinPointEntityBuilderV1(initialize: KotlinPointEntityBuilderV1.() -> Unit) : EntityBuilder {
    var x: Int = 0
    var y: Int = 0

    override fun build() = Point(x, y)

    init {
        initialize()
    }
}

