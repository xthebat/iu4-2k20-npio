package ru.bmstu.iu4.fadeev

import ru.bmstu.iu4.fadeev.desc.Person
import ru.bmstu.iu4.fadeev.table.Cell
import ru.bmstu.iu4.fadeev.table.Row
import ru.bmstu.iu4.fadeev.table.Table
import ru.inforion.lab403.common.extensions.maxIntValue
import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.toFile
import ru.inforion.lab403.common.logging.logger

object Starter {
    val log = logger()

    @JvmStatic
    fun main(args: Array<String>) {
        val file = "temp/generated.json".toFile()
        val text = file.readText()
        val json = text.parseJson<List<Person>>().filter { it.age in 21..29 }
        var rPos =1;
        val cntRow = json.filter { it.age in 21..29 }.map { it.name }.count()
        val maxDataLength = json.filter { it.age in 21..29 }.map { it.name.length }.maxOrNull()!!

        val rows = json.map {
            Row(
                it.name,                            //имя
                it.gender,                          //пол
                it.age.toString(),                  //возраст
                it.company,                         //компания
                it.balance,                         //баланс
                width = 15,                         //ширина, если нет автовыравнивания
                height = 5,                         //высота, если нет автовыравнивания
                rPos = rPos++,                      //текущая строка
                cntRow = cntRow,                    //общее количество строк
                maxDataLength = maxDataLength,      //максимальная ддлина данных
                cntChar = 9,                        //количество символов до переноса
                adjH = false,                       //выравнивание всех строк по высоте (по максимальной длине данных, с учетом переносов)
                adjW = false,                       //выравнивание всех столбцов по ширине (по максимальной длине данных, с учетом переносов)
                doubleBrdOff = true                 //удаление двойных границ
            )
        }

        val money = json.filter { it.age in 21..29 }.map { it.balance
                .dropWhile { it == '$' }
                .replace(",", "")
                .toFloat()
        }.sum()

        val table = Table(rows.toMutableList())
        val result = table.build()

        log.info { "\n$result" }
        log.info { "$$$ BALANCE = $money $$$" }
    }
}