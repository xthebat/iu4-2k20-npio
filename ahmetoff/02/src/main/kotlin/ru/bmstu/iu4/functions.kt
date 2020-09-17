package ru.bmstu.iu4

fun bubbleSort(toSort: MutableList<Int>){
    for (i in 0 until toSort.size) {
        for (i in 0 until toSort.size - 2) {
            if (toSort[i] > toSort[ i + 1]) {
                val tmp = toSort[i]
                toSort[i] = toSort[i + 1]
                toSort[i + 1] = tmp
            }
        }
    }
}