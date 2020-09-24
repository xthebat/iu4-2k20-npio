package ru.bmstu.iu4.task03

import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.toFile
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger
import java.io.BufferedWriter
import java.io.File


object Parser {
    val log = logger(FINEST)

    @JvmStatic
    fun main(args: Array<String>) {
        val path = "..\\..\\files\\task03\\generated.json"
        val data = personsParser(path)
        val writer = File("coolTable").bufferedWriter()

        writer.writeTable(data)
    }

    fun personsParser(path: String): List<Person> {
        val file = path.toFile().readText()
        return file.parseJson()
    }

    fun BufferedWriter.writeTable(data: List<Person>) {

        data.forEach {
            this.writeRow(it)
            this.newLine()
        }
        this.close()
    }


    fun BufferedWriter.writeRow(person: Person) {

        this.write(person.name)
        this.writeIndent(person.name.length)
        this.write(person.gender)
        this.writeIndent(person.gender.length)
        this.write(person.age.toString())
        this.writeIndent(person.age.toString().length)
        this.write(person.company)
        this.writeIndent(person.company.length)
        this.write(person.balance)
        this.writeIndent(person.balance.length)

    }

    fun BufferedWriter.writeIndent(length: Int) {
        val indent = 20

        repeat(indent - length) {
            this.write(" ")

        }
    }

    fun List<Person>.calcBalanceByAge(ageFrom: Int, ageTill: Int ): Double {
        val balances = mutableListOf<Double>()

        this.filter { it.age in ageFrom..ageTill }.forEach {
            balances.add(it.balance.converter())
        }

        val finalValue = Math.round(balances.sumByDouble { it } * 100.0) / 100.0
        return finalValue
    }

    fun String.converter(): Double {
        return this.replace("$", "").replace(",", "").toDouble()
    }
}

