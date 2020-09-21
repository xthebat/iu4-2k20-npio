package ru.bmstu.iu4.uzenkovD.task01.helloWorld

import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger


object FizzBuzzGameThirdVideo {
    private val log = logger(FINEST)

    @JvmStatic
    fun main(args: Array<String>) {
        log.warning { "Second entry point with another build config..." }
        log.severe { "DONT USE IT ON PROD, ONLY FOR FAST BULL* CODE" }

    }
}
