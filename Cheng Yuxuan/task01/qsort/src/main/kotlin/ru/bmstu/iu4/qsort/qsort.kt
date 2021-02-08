fun quick_sort(myArray: Array<Int>, leftIndex: Int, rightIndex: Int): Array<Int> {
    if (leftIndex < rightIndex) {
        var q: Int = partition(myArray, leftIndex, rightIndex)
        quick_sort(myArray, leftIndex, q - 1)
        quick_sort(myArray, q + 1, rightIndex)

    }
    return myArray
}

fun partition(myArray: Array<Int>, leftIndex: Int, rightIndex: Int): Int {
    var x = myArray[rightIndex]
    var i = leftIndex - 1
    for (j in leftIndex until rightIndex) {
        if (myArray[j] <= x) {
            i++
            exchange(myArray, i, j)
        }
    }
    exchange(myArray, i + 1, rightIndex)
    return i + 1
}

fun exchange(myArray: Array<Int>, i: Int, j: Int) {
    var temp = myArray[i]
    myArray[i] = myArray[j]
    myArray[j] = temp
}