package ru.bmstu.iu4.task01

import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger

object Start {

    val input: ArrayList<Int> = arrayListOf();
    val count: Int = 12;

    val log = logger(FINEST);

    @JvmStatic
    fun main(args: Array<String>) {
        while (input.size < count) { input.add((0..999).random()) };


        log.fine { "Load Input:  ${input.toString()} " }
        qSort(input)
        log.fine { "Unload Output: $input "}
    }


}


