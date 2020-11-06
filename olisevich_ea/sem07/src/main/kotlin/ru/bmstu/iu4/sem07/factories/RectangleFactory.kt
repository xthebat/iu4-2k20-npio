package ru.bmstu.iu4.sem07.factories

import ru.bmstu.iu4.sem07.impl.Rectangle
import ru.bmstu.iu4.sem07.interfaces.Factory

class RectangleFactory(val json: Map<String, Any>, val tag: Int) : Factory<Rectangle> {

    override fun generate(): Rectangle {
        val x = json["x"] as Int
        val y = json["y"] as Int
        val width = json["width"] as Int
        val height = json["height"] as Int

        return Rectangle(x, y, width, height, tag)
    }

}