package ru.bmstu.iu4.sem07.factories

import ru.bmstu.iu4.sem07.impl.Circle
import ru.bmstu.iu4.sem07.interfaces.Factory

class CircleFactory(val json: Map<String, Any>, val tag: Int) : Factory<Circle> {

    override fun generate(): Circle {
        val x = json["x"] as Int
        val y = json["y"] as Int
        val rad = json["radius"] as Int

        return Circle(x, y, rad, tag)
    }
}