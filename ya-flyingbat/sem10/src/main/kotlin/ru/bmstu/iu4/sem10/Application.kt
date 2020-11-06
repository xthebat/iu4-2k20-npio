package ru.bmstu.iu4.sem10

import ru.inforion.lab403.common.logging.logger

object Application {
    val log = logger()

    @JvmStatic
    fun main(args: Array<String>) {
        log.info { "Application started..." }
    }
}