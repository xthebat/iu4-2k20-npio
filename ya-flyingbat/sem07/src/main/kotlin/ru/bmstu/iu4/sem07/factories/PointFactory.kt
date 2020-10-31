package ru.bmstu.iu4.sem07.factories

import ru.bmstu.iu4.sem07.impl.Point
import ru.bmstu.iu4.sem07.interfaces.Drawable
import ru.bmstu.iu4.sem07.interfaces.Factory

// TODO
// https://en.wikipedia.org/wiki/Abstract_factory_pattern
// https://en.wikipedia.org/wiki/Factory_method_pattern
//class PointFactory(val json: Map<String, Any>) : Factory<Point> {
//    override fun generate(): Point {
//        val x = json["x"] as Int
//        val y = json["y"] as Int
//        return Point(x, y)
//    }
//}