package ru.bmstu.iu4.uzenkovD.task01.bubbleSort

import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger

object BubbleSortEntry {

    private val log = logger(FINEST)

    @JvmStatic
    fun main(args: Array<String>) {
        log.info { "program bubbleSort started..." }
        println("   Input string array: ${args.toList()}")
        val inputIntArray = convertInputArgs2Int(args)
        log.finest { "input int array: ${inputIntArray.contentToString()}" }

        log.info { "descending func bubbleSort started..." }
        val ascendSortedIntArray = bubbleSortAscend(inputIntArray)
        print("   Sorted ascending int array: ${ascendSortedIntArray.contentToString()}")

        log.info { "descending func bubbleSort started..." }
        val descendSortedIntArray = bubbleSortDescend(inputIntArray)
        print("   Sorted descending int array: ${descendSortedIntArray.contentToString()}")
    }
}
