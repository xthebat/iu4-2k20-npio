package ru.bmstu.iu4.HelloWorld

import org.joda.time.DateTime
import ru.inforion.lab403.common.extensions.writeJson
import ru.inforion.lab403.common.logging.FINE
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger

object Starter {
    val log = logger(FINE)

    @JvmStatic
    fun main(args: Array<String>) {
        log.warning { ("Hello, World! ${DateTime.now()}") }
        println("Hellow, world!")
    }
}