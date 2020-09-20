package ru.bmstu.iu4.task03

import ru.inforion.lab403.common.extensions.parseJson
import java.io.File

object Start {


    @JvmStatic
    fun main(args: Array<String>) {

        val data = File("generated.json").readText().parseJson<List<Person>>()

        val s = data.filter { it.age in 21..29 }.map {
            it.balance
                .replace("$", "")
                .replace(",", "").toFloat()
        }.sum()

        println("Person's sum in 20 < age < 30: $$s");

        val tab = createTable("Name Gender Age Company Balance", 9)
        data.forEach {
            tab.rowAdd("${it.name.replace(" ", "_")} ${it.gender} ${it.age} ${it.company} ${it.balance}")
        }

        val res = tab.initTable().printTable()

        File("output.txt").writeText(res)
    }

}