package ru.bmstu.iu4.qsort

object qsort {
    @JvmStatic

    fun main(args: Array<String>) {
        var temp: Int = 0
            var  IntArray = arrayOf(1, 9, 2, 13, 18, 7, 9, 27)
            for (i in 0 .. IntArray.size - 1) {
                for (j in 0..IntArray.size - 1) {
                    if (j < IntArray.size - 1) {
                        if (IntArray[j] > IntArray[j + 1]) {
                            if (j < IntArray.size - 1) {
                                temp = IntArray[j]
                                IntArray[j] = IntArray[j + 1]
                                IntArray[j + 1] = temp
                            }
                        }
                    }
                }
            }
            for (Number in IntArray)
            {
                println(Number)
            }
        }
}
