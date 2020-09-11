package ru.bmstu.iu4
import java.util.Arrays

object Starter {
    @JvmStatic
    fun main(args: Array<String>) {
        val data : Array <Int> = arrayOf(1,5,3,6,7,3,2,9)
        println(Arrays.toString(data))
        bubbleSort(data)
        println(Arrays.toString(data))
    }
    fun bubbleSort(toSort: Array<Int>) {
        for (j in 0..toSort.size) {
            for (k in 0..(toSort.size - 2)) {
                if (toSort[k] > toSort[k + 1]) {
                    val tmp = toSort[k]
                    toSort[k] = toSort[k + 1]
                    toSort[k + 1] = tmp
                }
            }
        }
    }
    }
