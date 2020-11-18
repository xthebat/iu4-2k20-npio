package ru.bmstu.iu4.sem07.factories

import ru.bmstu.iu4.sem07.impl.Circle
import ru.bmstu.iu4.sem07.interfaces.Factory

class CircleFactory(val json: Map<String, Any>): Factory<Circle> {
    override fun generate(): Circle{
        val center = PointFactory(json["center"] as Map<String, Any>).generate()
        val radius = json["radius"] as Int
        return Circle(center, radius)
    }
}