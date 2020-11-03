@file:Suppress("UNCHECKED_CAST")

package ru.bmstu.iu4.sem07.factories

import ru.bmstu.iu4.sem07.impl.Line
import ru.bmstu.iu4.sem07.impl.Point
import ru.bmstu.iu4.sem07.interfaces.Drawable
import ru.bmstu.iu4.sem07.interfaces.Factory

// TODO
// https://en.wikipedia.org/wiki/Abstract_factory_pattern
// https://en.wikipedia.org/wiki/Factory_method_pattern
//class LineFactory(val json: Map<String, Any>) : Factory<Line> {
//    override fun generate(): Line {
//        val src = PointFactory(json["src"] as Map<String, Any>).generate()
//        val dst = PointFactory(json["dst"] as Map<String, Any>).generate()
//        return Line(src, dst)
//    }
//}