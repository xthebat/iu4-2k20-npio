package ru.bmstu.iu4.task03

import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.toFile
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger
import java.io.BufferedWriter
import java.io.File

object Parser {
    val log = logger(FINEST)

    data class PersonImport(
        val _id: String,
        val index: Int,
        val guid: String,
        val isActive: Boolean,
        val balance: String,
        val picture: String,
        val age: Int,
        val eyeColor: String,
        val name: String,
        val gender: String,
        val company: String,
        val email: String,
        val phone: String,
        val address: String,
        val about: String,
        val registered: String,
        val latitude: Double,
        val longitude: Double,
        val tags: List<String>,
        val friends: Any,
        val greeting: String,
        val favoriteFruit: String
    )

    @JvmStatic
    fun main(args: Array<String>) {
        val path = "..\\..\\files\\task03\\generated.json"
        val data = personsParser(path)

        createTable(data)
        calculator(data)

        // name gender age company balance
        // age 20 .. 30 -> sum balance
    }
    fun personsParser(path: String): List<PersonImport> {
        val file = path.toFile().readText()
        return file.parseJson()
    }

    fun createTable(data: List<PersonImport>) {
        val writer = File("coolTable").bufferedWriter()
        data.forEach {
            createRow(it, writer)
            writer.newLine()
        }
        writer.close()
    }

    fun createRow(person: PersonImport, row: BufferedWriter) {

//        log.info { person.name }
        row.write(person.name)
        printIndent(person.name.length, row)
        row.write(person.gender)
        printIndent(person.gender.length, row)
        row.write(person.age.toString())
        printIndent(person.age.toString().length, row)
        row.write(person.company)
        printIndent(person.company.length, row)
        row.write(person.balance)
        printIndent(person.balance.length, row)

    }

    fun printIndent(length: Int, row: BufferedWriter) {
        val indent = 20

        for (i in 0 until indent - length) {
            row.write(" ")
        }
    }

    fun calculator(data: List<PersonImport>): Float {
        var balance = 0F
        data.filter{ it.age in 20..30 }.forEach() {
            log.info { it.age }
            log.info { it.balance }
            balance += converter(it.balance)
        }
        return balance
    }

    fun converter(string: String): Float {
        return string.replace("$", "").replace(",", "").toFloat()
    }
}

