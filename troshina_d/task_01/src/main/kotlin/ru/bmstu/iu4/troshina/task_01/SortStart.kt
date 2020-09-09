package ru.bmstu.iu4.troshina.task_01

object SortStart {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Введите числа, для окончания заполнения введите +")
        var myArray = makeArray()
        println("Вы ввели следующий массив: " + myArray.contentToString())
        myArray = qSort(myArray, 0, myArray.lastIndex)
        println("Отсортированный массив: " + myArray.contentToString())
    }
}