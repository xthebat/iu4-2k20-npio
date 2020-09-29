package ru.bmstu.iu4.uzenkovD.task01.helloWorld

import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger
import java.lang.NumberFormatException
import kotlin.system.exitProcess

object FunctionsRunner {
    private val log = logger(FINEST)

    @JvmStatic
    fun main(args: Array<String>) {
        log.finest { args.toList() } // convert to list because array has no beauty toString() method
        // try like if in Kotlin also expression
        val list = try {
            convertStrings2Ints(args)
        } catch (error: NumberFormatException) {
            log.severe { "Can't convert input arguments into ints!!!" }
            exitProcess(-1)
        }
        log.config { "Input array: $list" }  // this is string interpolation
        log.info { "Minimum value: ${min(list)}" }
        log.info { "Maximum value: ${max(list)}" }
        val threshold = 1
        val round = play(1, threshold, 'u')
        log.finest { "I've played in fizzbuzz for threshold $threshold and reached $round" }
    }
}
