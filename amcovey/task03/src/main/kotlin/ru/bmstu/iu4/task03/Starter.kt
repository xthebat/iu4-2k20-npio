package ru.bmstu.iu4.task03

object Starter {
    @JvmStatic
    fun main(args: Array<String>) {
        val jsonData = readDataFromJson("../../files/task03/generated.json")
        createTableFromJson(
            "../../files/task03/outputSourceTable",
            jsonData
        )
        createTableFromJson(
            "../../files/task03/outputFilteredTable",
            jsonData.filterByAge(20, 30)
        )
    }
}