package ru.bmstu.iu4.fadeev

import ru.inforion.lab403.common.logging.FINE
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger

object Starter {
    val log = logger(FINEST)
    @JvmStatic

    fun main(args: Array<String>) {

        println("Hello qsort!")

        val s = (0..99).shuffled().take(10)
        val inArr: ArrayList<Int> = s as ArrayList<Int>

        val m = 0
        val b = inArr.size-1

        log.fine { "Input array:  $inArr" }

        qsort(inArr, m, b)

        log.finest { "Output array: $inArr" }

    }
}