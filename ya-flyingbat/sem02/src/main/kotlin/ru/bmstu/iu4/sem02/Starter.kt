package ru.bmstu.iu4.sem02

import ru.inforion.lab403.common.extensions.writeJson
import ru.inforion.lab403.common.logging.logger

object Starter {
    val log = logger()

    @JvmStatic
    fun main(args: Array<String>) {
        val w = mapOf("list" to listOf(1, 2, 3)).writeJson()
        log.info { w }
        val y = listOf(1, 2, 3)
        val x = squareOutOfPlace(y)
        log.info { x }
    }
}