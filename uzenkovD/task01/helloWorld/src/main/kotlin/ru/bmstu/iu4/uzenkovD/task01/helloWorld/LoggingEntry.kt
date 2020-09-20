package ru.bmstu.iu4.uzenkovD.task01.helloWorld

import ru.inforion.lab403.common.extensions.writeJson
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


object LoggingEntry {
    private val log = logger(FINEST)

    @JvmStatic
    fun main(args: Array<String>) {
        println("Second entry point with another build config...")
        print("print drew char before bar, C THAT: | ")
        println("println create new line, print doesnt...")
        val moscowCurrentDateTime = ZonedDateTime.now(ZoneId.of("Europe/Moscow"))
        val beautifiedMoscowDateTime =
            moscowCurrentDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT))
        log.info { "ETS SO BUTUFUL MOSCOW TIME EEE: $beautifiedMoscowDateTime" }
        log.fine { "LOL DIFFERENCE COLORS C IT" }
        log.finer { "FINER" }
        log.finest { "FINEST GeTT Me my 2K007" }
        log.severe { "DONT kNOW WHAT DOES IT MEAN SEVERE??? MAYBE SEVERINO????" }
        log.config { "CONFIG ---- sounds like i dont know?" }
        log.warning { "ITS WARNENG MSG EUUUUUUUU" }
        log.finest { "AND TODAY MY FAV COLOR IS 2k007" }
        log.severe { "C THAT SHOW TIME, SEVERE==ERROR, but config ?" }
        log.config { "scale down ur screen backlight, config has another color" }
        log.config { "i think config used for msg about smth configurations" }
        log.finer { "god give mee prize im so clever" }
        log.fine { "so beautiful color on retina display" }


        val test = mapOf(
            "name" to "DRON",
            "ability" to "THE BEST",
            "gender" to listOf("COOLEST", "MAN", "IN DA WORLD")
        )
        val json = test.writeJson()

        log.finest { "\r\n${json}" }
    }
}
