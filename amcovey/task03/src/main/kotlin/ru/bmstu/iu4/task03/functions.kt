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
    val latitude: Float,
    val longitude: Float,
    val tags: Any,
    val friends: Any,
    val greeting: String,
    val favoriteFruit: String
)

fun readDataFromJson(inputFilePath: String): List<Person> {
    return inputFilePath.toFile()
        .readText()
        .parseJson()
}

fun printTableRow(row: String, longestSize: Int, writer: BufferedWriter) {
    writer.write(row)
    if (row.length < longestSize + 1) {
        val countOfSpaces = longestSize - row.length
        for (i in 0 until countOfSpaces + 1)
            writer.write(" ")
    }
    writer.write("|")
}

fun createTableFromJson(outputFilePath: String, jsonData: List<Person>) {
    val longestNameSize = maxOf(jsonData.maxOf { it.name.length }, "name: ".length)
    val longestGenderSize = maxOf(jsonData.maxOf { it.gender.length }, "gender: ".length)
    val longestAgeSize = maxOf(jsonData.maxOf { it.age }.toString().length, "age: ".length)
    val longestCompanySize = maxOf(jsonData.maxOf { it.company.length }, "company: ".length)
    val longestBalanceSize = maxOf(jsonData.maxOf { it.balance.length }, "balance: ".length)

    val writer = File(outputFilePath).bufferedWriter()
    printTableRow("name:", longestNameSize, writer)
    printTableRow("gender:", longestGenderSize, writer)
    printTableRow("age:", longestAgeSize, writer)
    printTableRow("company:", longestCompanySize, writer)
    printTableRow("balance:", longestBalanceSize, writer)
    writer.newLine()

    val namesList = jsonData.map { it.name }
    val gendersList = jsonData.map { it.gender }
    val agesList = jsonData.map { it.age }
    val companiesList = jsonData.map { it.company }
    val balancesList = jsonData.map { it.balance }
    for ((index, name) in namesList.withIndex()) {
        printTableRow(name, longestNameSize, writer)
        printTableRow(gendersList[index], longestGenderSize, writer)
        printTableRow(agesList[index].toString(), longestAgeSize, writer)
        printTableRow(companiesList[index], longestCompanySize, writer)
        printTableRow(balancesList[index], longestBalanceSize, writer)
        writer.newLine()
    }
    writer.close()
}

fun filterByAge(inputFilePath: String): List<Person> {
    val jsonData = readDataFromJson(inputFilePath)
    return jsonData.filter { (it.age >= 20) && (it.age <= 30) }
}

fun String.convertString2Float(): Float {
    return replace("$", "").replace(",", "").toFloat()
}

fun List<Person>.calcSumBalance(): Float = map { it.balance.convertString2Float() }.sum()
