<<<<<<< HEAD
package ru.bmstu.iu4

fun sort(sortArray: IntArray, leftIndex: Int, rightIndex: Int) {
    var leftIndexTemp = leftIndex
    var rightIndexTemp = rightIndex
    if (leftIndex > rightIndex)
        return

    val cardinalNum = sortArray[leftIndex]
    while (leftIndexTemp != rightIndexTemp) {

        while (sortArray[rightIndexTemp] >= cardinalNum && leftIndexTemp < rightIndexTemp)
            rightIndexTemp--

        while (sortArray[leftIndexTemp] <= cardinalNum && leftIndexTemp < rightIndexTemp)
            leftIndexTemp++

        if (leftIndexTemp < rightIndexTemp) {
            sortArray[leftIndexTemp] = sortArray[leftIndexTemp] xor sortArray[rightIndexTemp]
            sortArray[rightIndexTemp] = sortArray[leftIndexTemp] xor sortArray[rightIndexTemp]
            sortArray[leftIndexTemp] = sortArray[leftIndexTemp] xor sortArray[rightIndexTemp]
        }
    }
    sortArray[leftIndex] = sortArray[leftIndexTemp]
    sortArray[leftIndexTemp] = cardinalNum
    sort(sortArray, leftIndex, leftIndexTemp - 1)
    sort(sortArray, leftIndexTemp + 1, rightIndex)
}
=======
package ru.bmstu.iu4

fun sort(sortArray: IntArray, leftIndex: Int, rightIndex: Int) {
    var leftIndexTemp = leftIndex
    var rightIndexTemp = rightIndex
    if (leftIndex > rightIndex)
        return

    val cardinalNum = sortArray[leftIndex]
    while (leftIndexTemp != rightIndexTemp) {

        while (sortArray[rightIndexTemp] >= cardinalNum && leftIndexTemp < rightIndexTemp)
            rightIndexTemp--

        while (sortArray[leftIndexTemp] <= cardinalNum && leftIndexTemp < rightIndexTemp)
            leftIndexTemp++

        if (leftIndexTemp < rightIndexTemp) {
            sortArray[leftIndexTemp] = sortArray[leftIndexTemp] xor sortArray[rightIndexTemp]
            sortArray[rightIndexTemp] = sortArray[leftIndexTemp] xor sortArray[rightIndexTemp]
            sortArray[leftIndexTemp] = sortArray[leftIndexTemp] xor sortArray[rightIndexTemp]
        }
    }
    sortArray[leftIndex] = sortArray[leftIndexTemp]
    sortArray[leftIndexTemp] = cardinalNum
    sort(sortArray, leftIndex, leftIndexTemp - 1)
    sort(sortArray, leftIndexTemp + 1, rightIndex)
}
>>>>>>> master
