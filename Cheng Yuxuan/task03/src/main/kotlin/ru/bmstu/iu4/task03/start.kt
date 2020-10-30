package ru.bmstu.iu4.task03

object start {
    @JvmStatic
    fun main(args: Array<String>) {
        val jsonData = readDataFromJson("D:\\task03/generated.json")
        createTableFromJson(
            "D:\\task03/outputSourceTable",
            jsonData
        )
        createTableFromJson(
            "D:\\task03/outputFilteredTable",
            jsonData.filterByAge(20, 30)
        )
    }
}