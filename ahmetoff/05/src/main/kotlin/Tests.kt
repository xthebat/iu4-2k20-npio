import org.junit.Test
import ru.bmstu.iu4.common.Canvas
import ru.bmstu.iu4.common.write
import ru.bmstu.iu4.impl.Circle
import ru.bmstu.iu4.impl.Point
import ru.bmstu.iu4.impl.Rectangle

internal class Tests {
    @Test
    fun drawTest() {

        val point = Point(1.0, 1.0).apply {
            sym = '~'
        }
        val rectangle = Rectangle(Point(4.0, 3.0), Point(12.0, 6.0), 0).apply {
            border = '$'
        }
        val circle = Circle(Point(10.0, 10.0), 5.0, 1).apply {
            border = '|'
        }

        val list = listOf(point, rectangle, circle)

        val plot = Canvas(20, 20, 2).draw(list)

        plot.write()
    }
}