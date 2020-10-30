package ru.bmstu.iu4.task01

object SortEntry {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = intArrayOf(1, 200, 3, 6, 0, 100, 15, 10)
        println("Initial Array")
        x.printArray()
        println("Bubble Sort Increase")
        x.bubbleSortIncrease()
        x.printArray()
        println("Quick Sort Decrease")
        x.quickSortDecrease()
        x.printArray()
    }
}