package ru.bmstu.ahmetoff

object Starter {
    @JvmStatic
    fun main(args: Array<String>) {
        var NumbersToSort: Array<Int> = arrayOf(1, 3, 5, 3, 2)
        var i = 0
        var j = 0
        for (i in 0 .. NumbersToSort.size - 1) {
            for (j in 0..NumbersToSort.size - 1) {
                var tmp = 0
                if (j < NumbersToSort.size - 1) {
                    if (NumbersToSort[j] > NumbersToSort[j + 1]) {
                        if (j < NumbersToSort.size - 1) {
                            tmp = NumbersToSort[j]
                            NumbersToSort[j] = NumbersToSort[j + 1]
                            NumbersToSort[j + 1] = tmp
                        }
                    }
                }
            }
        }
        for (Number in NumbersToSort)
        {
            println(Number)
        }
    }
}