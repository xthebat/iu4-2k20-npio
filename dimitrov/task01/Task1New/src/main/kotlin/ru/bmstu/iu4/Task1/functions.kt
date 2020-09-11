package ru.bmstu.iu4.Task1

import java.security.KeyStore

fun unittest(): List<Int> {
    val testlist = listOf<Int>(5, 7, 2, 8)
    val sorttesttlist = sorting(testlist)
    return sorttesttlist
}

fun convert(array: Array<String>): List<Int> {
    val result = mutableListOf<Int>()
    for (item in array) result.add(item.toInt())
    return result
}

fun arraySize(list: List<Int>): Int {
    val listSize = list.size
    return listSize
}

fun sorting(list: List<Int>): List<Int> {
    var temporary: Int
    var swap = true
    val mutableArray = list.toIntArray()
    while (swap) {
        swap = false
        for (item_x in 0 until mutableArray.size-1) {
            if (mutableArray[item_x]>mutableArray[item_x+1]) {
                temporary = mutableArray[item_x + 1]
                mutableArray[item_x+1]=mutableArray[item_x]
                mutableArray[item_x]=temporary
                swap = true
            }
        }
    }
    return mutableArray.toList()
}