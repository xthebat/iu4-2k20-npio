package ru.bmstu.iu4.sem07.factories

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.interfaces.Factory

//TODO()
//https://en.wikipedia.org/wiki/Abstract_factory_pattern
//https://en.wikipedia.org/wiki/Factory_method_pattern
class DrawableFactory(val json: Map<String, Any>, val tag: Int = 0) : Factory<Entity> {
    override fun generate(): Entity {
        val type = json["type"] ?: throw IllegalArgumentException("Field 'type' not found in figure description!")

        return when (type) {
            "Point" -> PointFactory(json).generate()
            "Line" -> LineFactory(json).generate()
            "Rectangle" -> RectangleFactory(json, tag).generate()
            "Circle" -> CircleFactory(json, tag).generate()
            else -> throw IllegalArgumentException("Unsupported type=$type")
        }
    }
}