package ru.bmstu.iu4

import org.junit.Test
import java.util.*

internal class Tests {
    @Test
    fun bubbleSortTest () {
        val data : Array <Int> = arrayOf(1,5,3,6,7,3,2,9)
        println(Arrays.toString(data))
        Starter.bubbleSort(data)
        println(Arrays.toString(data))
    }

}