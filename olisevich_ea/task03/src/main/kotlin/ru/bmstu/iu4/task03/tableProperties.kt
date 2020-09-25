package ru.bmstu.iu4.task03

/**
 * Enum class with different coloring of table
 */

enum class LineTypes(val ch: String) {
    VS("||"), HS("__"), NN("  ")
}

data class ConfigRow(
    val cols: List<String>, var dataLen: Int = 5, var dataHeight: Int = 1,
    var left: Boolean = true, var right: Boolean = true,
    var top: Boolean = true, var bot: Boolean = true
)

data class ConfigTable(val maxlen: Int) {
    var dataTable: MutableList<String> = mutableListOf();
}