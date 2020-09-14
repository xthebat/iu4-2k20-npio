package ru.bmstu.iu4.fadeev

fun qsort(sArr: IntArray, m: Int, b: Int) {

    val med = (m+b)/2
    val osn = sArr[med]
    var i = m
    var j = b

    if (sArr.isEmpty()) {
        return
    }
    if (m >= b) {
        return
    }

    while (i <= j) {
        while (sArr[i] < osn) {
            i++
        }
        while (sArr[j] > osn) {
            j--
        }
        if (i <= j) {
            swap(sArr, i, j)
            i++
            j--
        }
    }
    if (m < j) {
        qsort(sArr, m, j)
    }
    if (b > i) {
        qsort(sArr, i, b)
    }
}

fun swap(sArr: IntArray, i: Int, j: Int ){

    val temp: Int = sArr[i]

    sArr[i] = sArr[j]
    sArr[j] = temp
}