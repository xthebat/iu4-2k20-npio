package ru.bmstu.iu4.task03

object Starter {
    @JvmStatic
    fun main(args: Array<String>) {
        createTableFromJson(
            "../../files/task03/outputSourceTable",
            readDataFromJson("../../files/task03/generated.json")
        )
        createTableFromJson(
            "../../files/task03/outputFilteredTable",
            filterByAge("../../files/task03/generated.json")
        )
    }
}