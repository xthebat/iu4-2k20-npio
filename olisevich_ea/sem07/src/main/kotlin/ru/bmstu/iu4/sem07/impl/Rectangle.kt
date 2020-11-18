package ru.bmstu.iu4.sem07.impl

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.interfaces.AreaCalculateable
import ru.bmstu.iu4.sem07.interfaces.Drawable
import ru.bmstu.iu4.sem07.interfaces.Printable
import ru.inforion.lab403.common.logging.logger
import kotlin.reflect.KProperty

// http://gameprogrammingpatterns.com/component.html
// TODO: implement
class Rectangle(val lb: Point, val rt: Point, val tag: Int = 0) : Entity() {
    companion object {
        val log = logger()
    }

    constructor(x: Int, y: Int, width: Int, height: Int, tag: Int = 0) :
            this(Point(x, y), Point(x + width, y + height), tag)

    val width get() = rt.x - lb.x
    val height get() = rt.y - lb.y

    // https://en.wikipedia.org/wiki/Delegation_pattern
    // https://en.wikipedia.org/wiki/Lazy_initialization
    class LazyObject<T : Any>(val action: () -> T) {
        private lateinit var value: T
        private var isInit = false

        operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
            if (!isInit) {
                value = action()
                isInit = true
            }
            return value
        }
    }

    // https://en.wikipedia.org/wiki/Lazy_initialization
    private val cache by LazyObject {
        log.fine { "Calculating rectangle markers: $this" }
        val lb = Point(lb.x, lb.y)
        val rt = Point(width - 1, height - 1)
        val lt = Point(lb.x, rt.y)
        val rb = Point(rt.x, lb.y)

        listOf(Line(lb, lt), Line(lt, rt), Line(rt, rb), Line(rb, lb))
    }

    internal val drawer = Drawable { plot ->
        cache.forEach { it.drawer.draw(plot) }
    }

    internal val areaCalculator = AreaCalculateable {
        width * height
    }

    internal val writer = Printable { writer ->
        writer.write("Rectangle(tag=$tag)\n")
    }

    init {
        log.fine { "Creating rectangle: $this" }
        require(lb.x < rt.x) { "$lb < $rt" }
        require(lb.y < rt.y) { "$lb < $rt" }
        addComponent(drawer)
        addComponent(areaCalculator)
        addComponent(writer)
    }

    override fun toString() = "Rectangle(tag=$tag)"

}