package ru.bmstu.iu4.sem07

import ru.bmstu.iu4.sem07.builders.JavaPointEntityBuilder
import ru.bmstu.iu4.sem07.builders.KotlinPointEntityBuilderV1
import ru.bmstu.iu4.sem07.builders.KotlinPointEntityBuilderV2
import ru.bmstu.iu4.sem07.common.*
import ru.bmstu.iu4.sem07.factories.DrawableFactory
import ru.bmstu.iu4.sem07.foreign.ForeignLine
import ru.bmstu.iu4.sem07.impl.*
import ru.inforion.lab403.common.extensions.getResourceAsStreamOfRoot
import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.logging.logger
import java.io.File

object Starter {
    val log = logger()

    fun loadFromJson(path: String): List<Map<String, Any>> = getResourceAsStreamOfRoot(path).parseJson()

    @JvmStatic
    fun main(args: Array<String>) {

        val json = loadFromJson("figures.json")

        log.info { json }

//        val map = json[0]

//        log.info { map["x"] ?: "null" }
        var i = 0
        val jsonFigures = json.map {
            DrawableFactory(it, i++).generate()
        }

//        log.info { jsonFigures }

        val point = JavaPointEntityBuilder()
            .setX(89)
//            .setY(20)
            .build()

        val pk = KotlinPointEntityBuilderV1 {
            this.x = 5
            y = 25
        }.build()

        val pk1 = KotlinPointEntityBuilderV2 {
            it.x = 5
            it.y = 25
        }.build()

        val point1 = Point(x = 89, y = 10)

//         Point.fromJson()

        val foreign = listOf(ForeignLine(11, 1, 11, 20))

        val figures = jsonFigures + Text("text to print")

        //val figures = listOf(
        //        point,
        //        pk,
        //        Line(Point(5, 10), Point(5, 16)),
        //        Line(Point(0, 0), Point(9, 15)),
        //        Line(Point(20, 20), Point(28, 28)),
        //        Rectangle(30, 2, 25, 20),
        //        Circle(60, 10, 7)
        //) + foreign.map { it.toDrawable() }

        Printer(System.out.writer()).print(figures)

        val canvas0 = Canvas(100, 30, 1).draw(figures).also { it.print() }
//        val canvas1 = Canvas(100, 30, 1).draw(figures).also { it.print() }

        AreaCalculator().calculate(figures).forEach{ (fig, area) -> log.fine { "Calculated area for $fig: $area" } }

        File("output.txt").bufferedWriter().use { canvas0.write(it) }
    }
}