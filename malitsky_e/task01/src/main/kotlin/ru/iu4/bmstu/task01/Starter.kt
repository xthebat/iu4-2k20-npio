package ru.iu4.bmstu.task01

object Starter {
    @JvmStatic
    fun main(args: Array<String>) {
        val x:IntArray = intArrayOf(540, 12, 420, 1, 0, 69)
        for (element:Int in x) {
            println(element)
        }
        qsort(x, 0, x.lastIndex)
        println("sorted:")
        for (element in x) {
            println(element)
        }
    }
    fun qsort(array: IntArray, begin: Int, end: Int) {
        val index = partition (array, begin, end)
        if (begin < end -1) {
            qsort(array, begin, end - 1)
        }
        if (index < end) {
            qsort(array, index, end)
        }
    }
    fun partition(array: IntArray, begin:Int, end:Int): Int {
        var left = begin
        var right = end
        val pivot = array[(left + right) / 2]
        while (left <= right) {
            while (array[left] < pivot)
                left++
            while (array[right] > pivot)
                right--
            if (left <= right) {
                swaptemp(array, left, right)
                left++
                right--
            }
        }
        return left
    }
    fun swaptemp(a: IntArray, b:Int, c:Int) {
        val temp = a[b]
        a[b] = a[c]
        a[c] = temp
    }
}
