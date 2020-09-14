package ru.bmstu.iu4.fadeev

object Starter {
    @JvmStatic
    fun main(args: Array<String>) {

        println("Hello world!")

        val s = (0..99).shuffled().take(10)
        val inArr = s.toIntArray()

        val m = 0
        val b = inArr.size-1

        println("Input array:")
        println(inArr.contentToString())

        qsort(inArr, m, b)

        println("Output array:")
        println(inArr.contentToString())

    }
}