package ru.bmstu.iu4.sem04

import ru.bmstu.iu4.sem04.desc.Person
import ru.bmstu.iu4.sem04.table.Cell
import ru.bmstu.iu4.sem04.table.Row
import ru.bmstu.iu4.sem04.table.Table
import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.toFile
import ru.inforion.lab403.common.logging.logger

object Starter {
    val log = logger()

    @JvmStatic
    fun main(args: Array<String>) {
        val file = "temp/generated.json".toFile()
        val text = file.readText()
        val json = text.parseJson<List<Person>>()

        log.info { json }

        val rows = json.take(10).mapIndexed { i, it -> Row(it.name, it.gender, it.email, it.balance, width = 15, maxChars = 10,
                                                verticalAlign = "mid", horizontalAlign = "center", height = 8, rowNum = i) }

        val table = Table(rows.toMutableList())

        table.adjustHeight()
        table.adjustWidth()

        val result = table.build()
        log.info { "\n$result" }
    }
}