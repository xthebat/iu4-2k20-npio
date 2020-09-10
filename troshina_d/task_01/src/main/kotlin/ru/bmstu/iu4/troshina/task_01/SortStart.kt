package ru.bmstu.iu4.troshina.task_01

object SortStart {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Введите числа, для окончания заполнения введите +")
        val myArray = makeArray()
        println("Вы ввели следующий массив: " + myArray.contentToString())
        println("Отсортированный массив: " + qSort(myArray, 0, myArray.lastIndex).contentToString())
    }
}