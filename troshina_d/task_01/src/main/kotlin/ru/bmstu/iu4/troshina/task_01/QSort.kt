package ru.bmstu.iu4.troshina.task_01

fun qSort(myArray: Array<Int>, leftIndex: Int, rightIndex: Int): Array<Int> {
    var startIndex = leftIndex
    var endIndex = rightIndex
    val cur = myArray[(startIndex + endIndex) / 2]

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
            startIndex++
            endIndex--
        }
    } while (startIndex <= endIndex)
    if (startIndex < rightIndex) {
        qSort(myArray, startIndex, rightIndex)
    }
    if (leftIndex < endIndex) {
        qSort(myArray, leftIndex, endIndex)
    }
    return myArray
}



fun Array<String>.convertStrings2Ints(): Array<Int> {
    if(this.isEmpty()){
        return arrayOf(0)
    }
    val result = Array(this.size) { 0 }
    for(k in this.indices){
        result[k] = this[k].toInt()
    }
    return result
}