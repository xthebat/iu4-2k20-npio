package ru.bmstu.iu4.uzenkovD.task01.bubbleSort

import ru.inforion.lab403.common.extensions.DynamicClassLoader.log
import java.lang.NumberFormatException
import kotlin.system.exitProcess

fun convertInputArgs2Int(array: Array<String>): Array<Int> {
    require(array.isNotEmpty()) { "Cant convert empty array!!!" }
    return try {
        array.map { it.toInt() }.toTypedArray()
    } catch (error: NumberFormatException) {
        log.severe { "Can't convert input string array to int array!!!" }
        exitProcess(-1)
    }
}

fun bubbleSortDescend(array: Array<Int>): Array<Int> {
    require(array.isNotEmpty()) { "Cant sort empty array!!!" }
    for (pass in 0 until (array.size - 1)) {
        for (currentPosition in 0 until (array.size - 1)) {
            if (array[currentPosition] < array[currentPosition + 1]) {
                val tmp = array[currentPosition]
                array[currentPosition] = array[currentPosition + 1]
                array[currentPosition + 1] = tmp
            }
        }
    }
    return array
}

fun bubbleSortAscend(array: Array<Int>): Array<Int> {
    require(array.isNotEmpty()) { "Cant sort empty array!!!" }
    for (pass in 0 until (array.size - 1)) {
        for (currentPosition in 0 until (array.size - 1)) {
            if (array[currentPosition] > array[currentPosition + 1]) {
                val tmp = array[currentPosition]
                array[currentPosition] = array[currentPosition + 1]
                array[currentPosition + 1] = tmp
            }
        }
    }
    return array
}
