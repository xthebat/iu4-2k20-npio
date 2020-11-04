package ru.bmstu.iu4.sem07.impl

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.interfaces.Drawable
import ru.bmstu.iu4.sem07.interfaces.Printable
import kotlin.math.abs

// http://gameprogrammingpatterns.com/component.html
class Line(val src: Point, val dst: Point) : Entity() {

    override fun toString() = "$src -> $dst"

    // https://en.wikipedia.org/wiki/Bridge_pattern
    // https://www.dofactory.com/net/bridge-design-pattern
    internal val drawer = Drawable { plot ->
        when {
            dst.y == src.y -> {
                val start = minOf(src.x, dst.x)
                val length = abs(dst.x - src.x)
                List(length) { Point(start + it, src.y) }
            }
            dst.x == src.x -> {
                val start = minOf(src.y, dst.y)
                val length = abs(dst.y - src.y)
                List(length) { Point(src.x, start + it) }
            }
            else -> {
                val start = minOf(src.x, dst.x)
                val dx = dst.x - src.x
                val dy = dst.y - src.y
                require(abs(dx) == abs(dy)) { "Only diagonal slope lines supported" }
                val slope = dy / dx  // may be only +/- 1
                List(abs(dx)) { Point(start + it, it * slope + src.y) }
            }
        }.forEach { it.drawer.draw(plot) }
        src.drawer.draw(plot)
        dst.drawer.draw(plot)
    }

    internal val writer = Printable { writer -> writer.write("Line$src -> $dst\n") }

    init {
        addComponent(drawer)
        addComponent(writer)
    }
}