fun quick_sort(A: Array<Int>, p: Int, r: Int) {
    if (p < r) {
        var q: Int = partition(A, p, r)
        quick_sort(A, p, q - 1)
        quick_sort(A, q + 1, r)

    }
}

fun partition(A: Array<Int>, p: Int, r: Int): Int {
    var x = A[r]
    var i = p - 1
    for (j in p until r) {
        if (A[j] <= x) {
            i++
            exchange(A, i, j)
        }
    }
    exchange(A, i + 1, r)
    return i + 1
}

fun exchange(A: Array<Int>, i: Int, j: Int) {
    var temp = A[i]
    A[i] = A[j]
    A[j] = temp
}