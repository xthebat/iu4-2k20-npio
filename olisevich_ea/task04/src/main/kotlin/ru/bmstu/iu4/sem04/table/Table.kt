package ru.bmstu.iu4.sem04.table

data class Table(val rows: MutableList<Row>) {

    constructor(vararg rows: Row) : this(rows.toMutableList())

    fun adjustHeight() {
        rows.forEach { it.adjustHeight() }
    }

    fun adjustWidth() {

        // Получаем транспанированную матрицу символов для удобного прохождения по столбцам таблицы
        val transposed = Array(rows.first().cells.size) { i -> Array(rows.size) { j -> rows[j].cells[i] } }
        val widthMap = ArrayList<Int>(transposed.size)
        // Проходим по каждому, отдельно взятому, столбцу таблицы и ищем самую длинную строку в этом столбце, сохраняем ее в ArrayList
        transposed.forEach { widthMap.add(it.maxBy { it.text.length }?.text?.length ?: 0) }

        // Далее устанавливаем всем ячейкам отдельно взятого столбца минимально-допустимую ширину, доставая значения из widthMap для соотв. столбца
        // Также в процессе проверяем на ограничение переноса строки maxChars
        rows.first().cells.forEachIndexed { i, it ->
            rows.forEachIndexed { j, row ->
                val maxChars = rows[j].cells[i].maxChars

                rows[j].cells[i].width = if (maxChars > widthMap[i]) widthMap[i] + 2 else maxChars + 2

            }
        }

    }

    fun build() = rows.joinToString("\n") { it.build() }
}