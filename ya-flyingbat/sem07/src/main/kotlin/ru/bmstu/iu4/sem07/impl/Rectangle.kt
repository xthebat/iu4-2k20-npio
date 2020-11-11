package ru.bmstu.iu4.sem07.impl

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.inforion.lab403.common.logging.logger
import kotlin.reflect.KProperty

// http://gameprogrammingpatterns.com/component.html
// TODO: implement
class Rectangle(val lb: Point, val rt: Point, tag: Int = 0): Entity() {
    companion object {
        val log = logger()
    }

    init {
        log.fine { "Creating rectangle: $this" }
    }

    constructor(x: Int, y: Int, width: Int, height: Int, tag: Int = 0) :
            this(Point(x, y), Point(x + width, y + height), tag)

    val width get() = rt.x - lb.x
    val height get() = rt.y - lb.y

//    override fun area(): Int = width * height
//
//    override fun stringify() = "Rectangle(tag=$tag)"

    // https://en.wikipedia.org/wiki/Delegation_pattern
    // https://en.wikipedia.org/wiki/Lazy_initialization
    class LazyObject<T: Any>(val action: () -> T) {
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
//    private val cache by LazyObject {
//        log.fine { "Calculating rectangle markers: $this" }
//        // TODO: Make list of points only with markers
//        plot(width, height).also { cachedPlot ->
//            val lb = Point(0, 0)
//            val rt = Point(width - 1, height - 1)
//            val lt = Point(lb.x, rt.y)
//            val rb = Point(rt.x, lb.y)
//            listOf(Line(lb, lt), Line(lt, rt), Line(rt, rb), Line(rb, lb), ).forEach { it.draw(cachedPlot) }
//        }
//    }
//
//    override fun draw(plot: Plot) {
//        repeat(cache.width) { x ->
//            repeat(cache.height) { y ->
//                val marker = cache.marker(x, y)
//                plot.draw(lb.x + x, lb.y + y, marker)
//            }
//        }
//    }
//
//    override fun print(writer: Writer) {
//        writer.write(stringify())
//    }

    override fun toString() = "[$lb, $rt]"

    init {
        require(lb.x < rt.x) { "$lb < $rt" }
        require(lb.y < rt.y) { "$lb < $rt" }
    }
}