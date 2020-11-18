package ru.bmstu.iu4.task03

import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.toFile
import java.io.BufferedWriter
import java.io.File

data class Person(
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
fun readDataFromJson(inputFilePath: String): List<Person> {
    return inputFilePath.toFile()
        .readText()
        .parseJson()
}

fun BufferedWriter.printTableCell(cell: String, longestSize: Int) {
    write(cell)
    if (cell.length < longestSize + 1) {
        repeat(longestSize - cell.length + 1) { write(" ") }
    }
    write("|")
}

fun createTableFromJson(outputFilePath: String, jsonData: List<Person>) {
    val longestNameSize = maxOf(jsonData.maxOf { it.name.length }, "name: ".length)
    val longestGenderSize = maxOf(jsonData.maxOf { it.gender.length }, "gender: ".length)
    val longestAgeSize = maxOf(jsonData.maxOf { it.age }.toString().length, "age: ".length)
    val longestCompanySize = maxOf(jsonData.maxOf { it.company.length }, "company: ".length)
    val longestBalanceSize = maxOf(jsonData.maxOf { it.balance.length }, "balance: ".length)

    val writer = File(outputFilePath).bufferedWriter()
    writer.printTableCell("name:", longestNameSize)
    writer.printTableCell("gender:", longestGenderSize)
    writer.printTableCell("age:", longestAgeSize)
    writer.printTableCell("company:", longestCompanySize)
    writer.printTableCell("balance:", longestBalanceSize)
    writer.newLine()

    jsonData.forEach {
        writer.printTableCell(it.name, longestNameSize)
        writer.printTableCell(it.gender, longestGenderSize)
        writer.printTableCell(it.age.toString(), longestAgeSize)
        writer.printTableCell(it.company, longestCompanySize)
        writer.printTableCell(it.balance, longestBalanceSize)
        writer.newLine()
    }
    writer.close()
}

fun List<Person>.filterByAge(minAge: Int, maxAge: Int): List<Person> {
    return filter { (it.age >= minAge) && (it.age <= maxAge) }
}

fun String.convertString2Float(): Float {
    return replace("$", "").replace(",", "").toFloat()
}

fun List<Person>.calcSumBalance(): Float = map { it.balance.convertString2Float() }.sum()