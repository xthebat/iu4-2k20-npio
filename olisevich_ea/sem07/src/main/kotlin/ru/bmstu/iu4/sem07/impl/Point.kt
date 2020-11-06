package ru.bmstu.iu4.sem07.impl

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.common.draw
import ru.bmstu.iu4.sem07.interfaces.Drawable
import ru.bmstu.iu4.sem07.interfaces.Printable

// http://gameprogrammingpatterns.com/component.html
class Point(val x: Int, val y: Int) : Entity() {
    override fun toString() = "($x, $y)"

    // https://en.wikipedia.org/wiki/Bridge_pattern
    // https://www.dofactory.com/net/bridge-design-pattern
    internal val drawer = Drawable { plot -> plot.draw(x, y, '*') }

    internal val writer = Printable { writer -> writer.write("Point($x, $y)\n") }

    init {
        addComponent(drawer)
        addComponent(writer)
    }
}