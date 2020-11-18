package ru.bmstu.iu4.korchagin.task03

import ru.inforion.lab403.common.extensions.parseJson
import java.io.File

object Starter {

    data class Friends(
        val id: Int,
        val name: String
    )

    data class Data(
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
        val tags: List<String>,
        val friends: List<Friends>,
        val greeting: String,
        val favoriteFruit: String
    )

    @JvmStatic
    fun main(args: Array<String>) {
        val file = File("generated.json").readText()

        val json = file.parseJson<List<Data>>()

        json.filter { it.index == 0 }

        var totalBalance = json.filter { it.age > 20 && it.age < 30 }.fold(0F) { acc, it ->
            if (acc == 0F) {
                println("NAME\t\t\t\tGENDER\tAGE\tCOMPANY\t\tBALANCE")
            }
            val result = acc + it.balance.replace("$", "").replace(",", "").toFloat()
            setwR(it.name, 20)
            setwR(it.gender, 8)
            setwR(it.age.toString(), 4)
            setwR(it.company, 12)
            setwR(it.balance, 10)
            println()
            result
        }
        for (i in 0 .. 53){
            print("-")
        }
        println()
        setwL("Total = " + getPriceToFloat(totalBalance), 53)
    }


}