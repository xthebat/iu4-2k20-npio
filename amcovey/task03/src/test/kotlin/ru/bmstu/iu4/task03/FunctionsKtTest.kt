package ru.bmstu.iu4.task03

import org.junit.Test
import kotlin.test.assertEquals

internal class FunctionsKtTest {

    @Test
    fun convertString2FloatTest() {
        val string = "$2,969.72"
        val result = 2969.72F
        assertEquals(result, string.convertString2Float())
    }

    /**
     * Test - Calc sum of balance for persons with age from 20 to 30
     */
    @Test
    fun calcSumBalanceTest() {
        val filteredList = readDataFromJson("../../files/task03/generated.json")
                .filterByAge(20, 30)
        val result = 41190.4F
        assertEquals(result, filteredList.calcSumBalance())
    }
}