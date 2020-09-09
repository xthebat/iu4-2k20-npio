package ru.bmstu.iu4.hellow

object qsort {
    @JvmStatic
    fun main(args: Array<String>) {
        var temp: Int = 0
        var intArray = intArrayOf(5, 7, 1, 3, 2, 9, 4)

        var n: Int = intArray.size
        for (i in 0..(n-2)){
            for (j in 0..(n-2)){
                if (intArray[j] > intArray[j+1]){
                    temp = intArray[j]
                    intArray[j] = intArray[j+1]
                    intArray[j+1]  = temp
                }

            }
        }
        for (result in intArray){
            print(result)
        }


    }
}