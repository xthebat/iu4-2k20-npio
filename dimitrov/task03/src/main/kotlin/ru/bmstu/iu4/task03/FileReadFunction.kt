<<<<<<< HEAD
package ru.bmstu.iu4.task03

import ru.bmstu.iu4.task03.data.CharacterData
import ru.bmstu.iu4.task03.data.Person
import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.toFile
import java.io.File

fun loadPersonFromFile(file: File): List<Person> {
    val text = file.readText()
    return text.parseJson()
}

fun outputFile(LoadFile: String) {
    val global = loadPersonFromFile(LoadFile.toFile())
    val writerPerson = File("OutputFile.txt").bufferedWriter()

    val table: Array<Array<String>> = Array(global.lastIndex+1) { Array(24) { "0" } }
    val table2: MutableList<List<String>> = List(global.lastIndex+1) { List(24) {"0"} }.toMutableList()

    /*table2[0] = mutableListOf("|  |", "|_id|", "|index|", "|guid|", "isActive|", "|balance|", "|picture|", "|age|", "|eyeColor|",
        "|name|", "|gender|", "|company|", "|email|", "|phone|", "|address|", "|about|", "|registered|", "|latitude|", "|longitude|",
        "|tags|", "|friends|", "|greeting|", "|favoriteFruit|\n")*/

    for (i in 0..global.lastIndex) {
        table2.add(i, listOf<String>(
                "Next user: \n_id: ${global[i]._id} \n",
                "index: ${global[i].index.toString()} \n",
                "Guid: ${global[i].guid} \n",
                "isActive: ${global[i].isActive.toString()} \n",
                "Balance: ${global[i].balance} \n",
                "Picture: ${global[i].picture} \n",
                "Age: ${global[i].age.toString()} \n",
                "EyeColor: ${global[i].eyeColor} \n",
                "Name: ${global[i].name} \n",
                "Gender: ${global[i].gender} \n",
                "Company: ${global[i].company} \n",
                "Email: ${global[i].email} \n",
                "Phone: ${global[i].phone} \n",
                "Address: ${global[i].address} \n",
                "About: ${global[i].about}",
                "Registered: ${global[i].registered} \n",
                "Latitude: ${global[i].latitude.toString()} \n",
                "Longitude: ${global[i].longitude.toString()} \n",
                "Tags: ${global[i].tags.toString()} \n",
                "Friends: ${global[i].friends.toString()} \n",
                "Greeting: ${global[i].greeting} \n",
                "FavoriteFruit: ${global[i].favoriteFruit} \n\n"
        ))
    }

    writerPerson.write(table2.toString())
    //global.forEach { writerPerson.write(it.toString()) }
}

fun sumBalance(ListPerson: List<Person>, LoadFile: String): Float {
    val functionGlobal = loadPersonFromFile(LoadFile.toFile())
    var sumSalary: Float = 0f
    val balanceFilter = functionGlobal.filter { it.age in 25..35 }.map {
        sumSalary += it.balance
            .replace(",", "")
            .replace("$", "")
            .toFloat()
    }
    return sumSalary
=======
package ru.bmstu.iu4.task03

import ru.bmstu.iu4.task03.data.CharacterData
import ru.bmstu.iu4.task03.data.Person
import ru.inforion.lab403.common.extensions.parseJson
import ru.inforion.lab403.common.extensions.toFile
import java.io.File

fun loadPersonFromFile(file: File): List<Person> {
    val text = file.readText()
    return text.parseJson()
}

fun outputFile(LoadFile: String) {
    val global = loadPersonFromFile(LoadFile.toFile())
    val writerPerson = File("OutputFile.txt").bufferedWriter()

    val table: Array<Array<String>> = Array(global.lastIndex+1) { Array(24) { "0" } }
    val table2: MutableList<List<String>> = List(global.lastIndex+1) { List(24) {"0"} }.toMutableList()

    /*table2[0] = mutableListOf("|  |", "|_id|", "|index|", "|guid|", "isActive|", "|balance|", "|picture|", "|age|", "|eyeColor|",
        "|name|", "|gender|", "|company|", "|email|", "|phone|", "|address|", "|about|", "|registered|", "|latitude|", "|longitude|",
        "|tags|", "|friends|", "|greeting|", "|favoriteFruit|\n")*/

    for (i in 0..global.lastIndex) {
        table2.add(i, listOf<String>(
                "Next user: \n_id: ${global[i]._id} \n",
                "index: ${global[i].index.toString()} \n",
                "Guid: ${global[i].guid} \n",
                "isActive: ${global[i].isActive.toString()} \n",
                "Balance: ${global[i].balance} \n",
                "Picture: ${global[i].picture} \n",
                "Age: ${global[i].age.toString()} \n",
                "EyeColor: ${global[i].eyeColor} \n",
                "Name: ${global[i].name} \n",
                "Gender: ${global[i].gender} \n",
                "Company: ${global[i].company} \n",
                "Email: ${global[i].email} \n",
                "Phone: ${global[i].phone} \n",
                "Address: ${global[i].address} \n",
                "About: ${global[i].about}",
                "Registered: ${global[i].registered} \n",
                "Latitude: ${global[i].latitude.toString()} \n",
                "Longitude: ${global[i].longitude.toString()} \n",
                "Tags: ${global[i].tags.toString()} \n",
                "Friends: ${global[i].friends.toString()} \n",
                "Greeting: ${global[i].greeting} \n",
                "FavoriteFruit: ${global[i].favoriteFruit} \n\n"
        ))
    }

    writerPerson.write(table2.toString())
    //global.forEach { writerPerson.write(it.toString()) }
}

fun sumBalance(ListPerson: List<Person>, LoadFile: String): Float {
    val functionGlobal = loadPersonFromFile(LoadFile.toFile())
    var sumSalary: Float = 0f
    val balanceFilter = functionGlobal.filter { it.age in 25..35 }.map {
        sumSalary += it.balance
            .replace(",", "")
            .replace("$", "")
            .toFloat()
    }
    return sumSalary
>>>>>>> master
}