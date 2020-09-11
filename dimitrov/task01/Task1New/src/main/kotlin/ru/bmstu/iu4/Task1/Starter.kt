package ru.bmstu.iu4.Task1

import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger
import java.lang.NumberFormatException
import kotlin.system.exitProcess

object Starter {
    var log = logger(FINEST)

    @JvmStatic
    fun main(args: Array<String>) {
        val list = try {
            convert(args)
        } catch (error: NumberFormatException) {
            log.severe { "Can't convert" }
            exitProcess(-1)
        }
        log.info { "Input array: $list" }
        log.info { "Size of array: ${arraySize(list)}" }
        log.info { "Sorting array: ${sorting(list)}" }
        log.info { "Unit test, input array: 5 7 2 8, sort: ${unittest()}"}
    }
}