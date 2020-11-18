package ru.bmstu.iu4.sem07.factories

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.interfaces.Drawable
import ru.bmstu.iu4.sem07.interfaces.Factory
import ru.bmstu.iu4.sem07.interfaces.Printable
import java.awt.Rectangle

// TODO()
// https://en.wikipedia.org/wiki/Abstract_factory_pattern
// https://en.wikipedia.org/wiki/Factory_method_pattern
class DrawableFactory(val json: Map<String, Any>) : Factory<Entity> {
    override fun generate(): Entity {
        val type = json["type"] ?: throw IllegalArgumentException("Field 'type' not found in figure description!")

        return when (type) {
            "Point" -> PointFactory(json).generate()
            "Line" -> LineFactory(json).generate()
            "Circle" -> CircleFactory(json).generate()
            "Rectangle" -> RectangleFactory(json).generate()
            else -> throw IllegalArgumentException("Unsupported type=$type")
        }
    }
}