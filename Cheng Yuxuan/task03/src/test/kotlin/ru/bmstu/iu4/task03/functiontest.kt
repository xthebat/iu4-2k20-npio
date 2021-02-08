<<<<<<< HEAD
package ru.bmstu.iu4.task03.ru.bmstu.iu4.task03

import org.junit.Test
import ru.bmstu.iu4.task03.calcSumBalance
import ru.bmstu.iu4.task03.convertString2Float
import ru.bmstu.iu4.task03.filterByAge
import ru.bmstu.iu4.task03.readDataFromJson
import kotlin.test.assertEquals

internal class FunctionsKtTest {

    @Test
    fun convertString2FloatTest() {
        val string = "$2,969.72"
        val result = 2969.72F
        assertEquals(result, string.convertString2Float())
    }
    @Test
    fun calcSumBalanceTest() {
        val filteredList = readDataFromJson("D:\\task03/generated.json")
            .filterByAge(20, 30)
        val result = 2354.64F
        assertEquals(result, filteredList.calcSumBalance())
    }
=======
package ru.bmstu.iu4.task03.ru.bmstu.iu4.task03

import org.junit.Test
import ru.bmstu.iu4.task03.calcSumBalance
import ru.bmstu.iu4.task03.convertString2Float
import ru.bmstu.iu4.task03.filterByAge
import ru.bmstu.iu4.task03.readDataFromJson
import kotlin.test.assertEquals

internal class FunctionsKtTest {

    @Test
    fun convertString2FloatTest() {
        val string = "$2,969.72"
        val result = 2969.72F
        assertEquals(result, string.convertString2Float())
    }
    @Test
    fun calcSumBalanceTest() {
        val filteredList = readDataFromJson("D:\\task03/generated.json")
            .filterByAge(20, 30)
        val result = 2354.64F
        assertEquals(result, filteredList.calcSumBalance())
    }
>>>>>>> master
}