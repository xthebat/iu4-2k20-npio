<<<<<<< HEAD
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
        writer.close()
    }

    fun personsParser(path: String): List<Person> {
        val file = path.toFile().readText()
        return file.parseJson()
    }

    fun BufferedWriter.writeTable(data: List<Person>) {

        data.forEach {
            writeRow(it)
            newLine()
        }
    }


    fun BufferedWriter.writeRow(person: Person) {

        write(person.name)
        writeIndent(person.name.length)
        write(person.gender)
        writeIndent(person.gender.length)
        write(person.age.toString())
        writeIndent(person.age.toString().length)
        write(person.company)
        writeIndent(person.company.length)
        write(person.balance)
        writeIndent(person.balance.length)

    }

    fun BufferedWriter.writeIndent(length: Int) {
        val indent = 20

        repeat(indent - length) { write(" ") }
    }

    fun List<Person>.calcBalanceByAge(ageFrom: Int, ageTill: Int ): Double {
        val balances = mutableListOf<Double>()

        filter { it.age in ageFrom..ageTill }.forEach {
            balances.add(it.balance.converter())
        }

        val finalValue = Math.round(balances.sumByDouble { it } * 100.0) / 100.0
        return finalValue
    }

    fun String.converter(): Double {
        return replace("$", "").replace(",", "").toDouble()
    }
}

=======
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
        writer.close()
    }

    fun personsParser(path: String): List<Person> {
        val file = path.toFile().readText()
        return file.parseJson()
    }

    fun BufferedWriter.writeTable(data: List<Person>) {

        data.forEach {
            writeRow(it)
            newLine()
        }
    }


    fun BufferedWriter.writeRow(person: Person) {

        write(person.name)
        writeIndent(person.name.length)
        write(person.gender)
        writeIndent(person.gender.length)
        write(person.age.toString())
        writeIndent(person.age.toString().length)
        write(person.company)
        writeIndent(person.company.length)
        write(person.balance)
        writeIndent(person.balance.length)

    }

    fun BufferedWriter.writeIndent(length: Int) {
        val indent = 20

        repeat(indent - length) { write(" ") }
    }

    fun List<Person>.calcBalanceByAge(ageFrom: Int, ageTill: Int ): Double {
        val balances = mutableListOf<Double>()

        filter { it.age in ageFrom..ageTill }.forEach {
            balances.add(it.balance.converter())
        }

        val finalValue = Math.round(balances.sumByDouble { it } * 100.0) / 100.0
        return finalValue
    }

    fun String.converter(): Double {
        return replace("$", "").replace(",", "").toDouble()
    }
}

>>>>>>> master
