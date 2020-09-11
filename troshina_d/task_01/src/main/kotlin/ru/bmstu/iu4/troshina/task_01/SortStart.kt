package ru.bmstu.iu4.troshina.task_01

object SortStart {
    @JvmStatic
    fun main(args: Array<String>) {
        val myArray = args.convertStrings2Ints()
        println("Your array: ${myArray.contentToString()}")
        println("Sorted array: " + qSort(myArray, 0, myArray.lastIndex).contentToString())
    }
}