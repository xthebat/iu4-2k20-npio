package ru.bmstu.iu4.Sem04

import ru.bmstu.iu4.Sem04.Classes.Person
import ru.bmstu.iu4.Sem04.createTable.*
import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.toFile
import ru.inforion.lab403.common.logging.logger

object Starter {
    val log = logger()

    @JvmStatic
    fun main(args: Array<String>) {
        val file = ("C:/Users/Nikita/generated.json").toFile()
        val text = file.readText()
        val json = text.parseJson<List<Person>>()

        log.info { json }

        val maxWidth = maxWidth(
            json.take(3)[0].name, json.take(3)[0].gender,
            json.take(3)[0].balance, json.take(3)[0].email, width = 5) //авто расширение под максимальное слово (по кол. букв до пробела
        val maxHeight = maxHeight(
            json.take(3)[0].name, json.take(3)[0].gender,
            json.take(3)[0].balance, json.take(3)[0].email, width = maxWidth) //авто расширение под максимальную ширину
        val tableSizes = buildInTable(3, 4) //размеры таблицы
        val col = counter(3) // сколько элементов мы берем из json файла

        val rows = json.take(3).map {
            Row(it.name, it.gender, it.balance, it.email, width = 10,
                height = 5, maxHeight = maxHeight, maxWidth = maxWidth, protocol = tableSizes, col = col) }
        val table = Table(rows.toMutableList())

        val result = table.build()
        log.info { "\n$result" }
    }
}