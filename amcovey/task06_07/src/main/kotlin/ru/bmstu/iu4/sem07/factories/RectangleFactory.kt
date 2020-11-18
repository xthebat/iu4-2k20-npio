package ru.bmstu.iu4.sem07.factories

import ru.bmstu.iu4.sem07.impl.Rectangle
import ru.bmstu.iu4.sem07.interfaces.Factory

class RectangleFactory(val json: Map<String, Any>):Factory<Rectangle> {
    override fun generate(): Rectangle {
        val lb = PointFactory(json["lb"] as Map<String, Any>).generate()
        val rt = PointFactory(json["rt"] as Map<String, Any>).generate()
        return Rectangle(lb, rt)
    }
}