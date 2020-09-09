package ru.bmstu.iu4.troshina.task_01
import java.util.*
val scan = Scanner(System.`in`)

fun qSort(myArray: Array<Int>, leftIndex: Int, rightIndex: Int): Array<Int> {
    var startIndex = leftIndex
    var endIndex = rightIndex
    val cur: Int = myArray[(startIndex + endIndex) / 2]

    do {
        while (myArray[startIndex] < cur) {
            startIndex++
        }
        while (myArray[endIndex] > cur) {
            endIndex--
        }
        if (startIndex <= endIndex) {
            if (startIndex < endIndex) {
                val tmp = myArray[startIndex]
                myArray[startIndex] = myArray[endIndex]
                myArray[endIndex] = tmp
            }
            startIndex++;
            endIndex--;
        }
    } while (startIndex <= endIndex)
    if (startIndex < rightIndex) {
        qSort(myArray, startIndex, rightIndex);
    }
    if (leftIndex < endIndex) {
        qSort(myArray, leftIndex, endIndex);
    }
    return myArray
}

fun makeArray():Array<Int>{
    var myArray = emptyArray<Int>()
    while (scan.hasNextInt()) {
        myArray += scan.nextInt()
        scan.nextLine()
    }
    return myArray
}