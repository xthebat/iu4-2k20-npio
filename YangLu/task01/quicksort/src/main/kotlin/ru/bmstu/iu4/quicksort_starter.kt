package ru.bmstu.iu4

import java.util.*

object quicksort_starter {

    @JvmStatic
    fun main(args: Array<String>) {

        val sortArray = IntArray(10)
        val ra = Random()

        println("Random Array：")
        for (i in sortArray.indices) {
            sortArray[i] = ra.nextInt(100)
            print("${sortArray[i]} ")
        }
        println()
        sort(sortArray, 0, sortArray.size - 1)
        println("Sorted Array：")
        for (i in sortArray) {
            print("${i} ")
        }
    }
}