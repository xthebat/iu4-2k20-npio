package ru.bmstu.iu4.task01

fun IntArray.printArray(){
    for ((index, value) in this.withIndex())
        println("[$index]: $value")
}

fun IntArray.bubbleSortIncrease(): IntArray{
    for (i in 0 until (this.size - 1)){
        for (j in 0 until (this.size - i - 1)){
            if (this[j] > this[j + 1]){
                this[j] = this[j + 1].also { this[j + 1] = this[j] }
            }
        }
    }
    return this
}

fun IntArray.quickSortDecrease(){
    var startIndex: Int = 0
    var endIndex: Int = this.lastIndex
    makeSort(this, startIndex, endIndex)
}

fun makeSort(array: IntArray, startIndex: Int, endIndex: Int){
    if (startIndex >= endIndex)
        return
    var i: Int = startIndex
    var j: Int = endIndex
    var curr: Int = i - (i - j) / 2
    while (i < j){
        while (i < curr && (array[i] >= array[curr])) {
            i++
        }
        while (j > curr && (array[curr] >= array[j])){
            j--
        }
        if (i < j){
            array[j] = array[i].also { array[i] = array[j] }
            if (i == curr)
                curr = j
            else if (j == curr)
                curr = i
        }
    }
    makeSort(array, startIndex, curr)
    makeSort(array, curr + 1, endIndex)
}