package ru.bmstu.iu4.sem07

import ru.bmstu.iu4.sem07.adaptors.toDrawable
import ru.bmstu.iu4.sem07.builders.JavaPointEntityBuilder
import ru.bmstu.iu4.sem07.builders.KotlinPointEntityBuilderV1
import ru.bmstu.iu4.sem07.builders.KotlinPointEntityBuilderV2
import ru.bmstu.iu4.sem07.common.Canvas
import ru.bmstu.iu4.sem07.common.Printer
import ru.bmstu.iu4.sem07.common.print
import ru.bmstu.iu4.sem07.common.write
import ru.bmstu.iu4.sem07.factories.DrawableFactory
import ru.bmstu.iu4.sem07.foreign.ForeignLine
import ru.bmstu.iu4.sem07.impl.*
import ru.inforion.lab403.common.extensions.getResourceAsStreamOfRoot
import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.toFile
import ru.inforion.lab403.common.logging.logger
import java.io.File

object Starter {
    val log = logger()

    fun loadFromJson(path: String): List<Map<String, Any>> = getResourceAsStreamOfRoot(path).parseJson()

    @JvmStatic
    fun main(args: Array<String>) {

        val json = loadFromJson("figures.json")

        log.info { json }

        val jsonFigures = json.map {
            DrawableFactory(it).generate()
        }

        Printer(System.out.writer()).print(jsonFigures)
        val canvas0 = Canvas(100, 50, 1).draw(jsonFigures).also { it.print() }
//        val canvas1 = Canvas(100, 30, 1).draw(figures).also { it.print() }
        File("output.txt").bufferedWriter().use { canvas0.write(it) }
    }
}