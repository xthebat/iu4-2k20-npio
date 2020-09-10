package ru.bmstu.iu4.qsort

import quick_sort

object Quick_sortStart {
    @JvmStatic
    fun main(arg: Array<String>) {
        print("Enter no. of elements :")
        val n = readLine()!!.toInt()

        println("Enter elements : ")
        val A = Array(n, { 0 })
        for (i in 0 until n)
            A[i] = readLine()!!.toInt()

        quick_sort(A, 0, A.size - 1)

        println("Sorted array is : ")
        for (i in 0 until n)
            print("${A[i]}  ")
    }
}