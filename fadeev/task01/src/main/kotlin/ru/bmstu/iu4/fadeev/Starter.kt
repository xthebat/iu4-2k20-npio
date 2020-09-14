package ru.bmstu.iu4.fadeev

import ru.inforion.lab403.common.logging.FINE
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger

object Starter {
    val log = logger(FINEST)
    @JvmStatic

    fun main(args: Array<String>) {

        println("Hello world!")

        val s = (0..99).shuffled().take(10)
        val inArr = s.toIntArray()

        val m = 0
        val b = inArr.size-1

        log.fine { "\nInput array:" }
        println(inArr.contentToString())

        qsort(inArr, m, b)

        log.finest {"\nOutput array:"}
        println(inArr.contentToString())

    }
}