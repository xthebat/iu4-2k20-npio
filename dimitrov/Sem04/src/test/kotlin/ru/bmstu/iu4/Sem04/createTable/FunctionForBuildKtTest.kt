<<<<<<< HEAD
package ru.bmstu.iu4.Sem04.createTable

import org.junit.Test
import ru.bmstu.iu4.Sem04.Starter
import kotlin.test.assertEquals

internal class FunctionForBuildKtTest {

    @Test
    fun newMaxHeightTest() {
        val stringTest = "123456789"
        val width = 3
        val expected = 2
        val result = stringTest.newMaxHeight(width)
        assertEquals(expected, result)
    }

    @Test
    fun adjustHeightTest() {
        val testList = listOf<String>("123 123", "456 456")
        var maxWidth: Int = 0
        for (i in 0..testList.lastIndex) {
            val temp = testList[i].split(" ")
            for (k in 0..temp.lastIndex) { if (temp[k].length > 2) maxWidth = temp[k].length}
        }
        println(maxWidth)
    }

    @Test
    fun maxWidthTest() {
        val res = maxWidth("odineddddd", "dva", "tri3d", width = 2)
        assertEquals(10, res)
    }

    @Test
    fun maxHeightTest() {
        val r = maxHeight("ten10ten10", "eleven11111", width = 10)
        println(r)
        assertEquals(2, r)
    }

    @Test
    fun centralizationTest() {
        val temp = "center"
        val width = 7
        val test = temp.centralization(width)
        println(test)
        assertEquals(7, test.length)
    }

    @Test
    fun buildInTableTest() {
        val constructorCase = Array(3) { Array(3) { 0 } }
        constructorCase[0] = arrayOf(1, 2, 2)
        constructorCase[1] = arrayOf(3, 4, 4)
        constructorCase[2] = arrayOf(3, 4, 4)
        val test = buildInTable(3, 3)
        for (i in 0..2) {
            println(test[0][i])
            println(test[1][i])
            println(test[2][i])
        }
        assertEquals(constructorCase, test)
        //я не знаю почему этот тест показывает ошибку :(
    }

    @Test
    fun counterTest() {
        val expected = listOf<Int>(0, 1, 2)
        val result = counter(3)
        assertEquals(expected, result)
    }

    @Test
    fun tableTest() {
        val expected = mutableListOf<String>()
        expected.add("\n|----|----|\n|odin| dva|\n|    |    |\n|----|----|")

        val res = Row("odin", "dva", width = 3, height = 1, maxHeight = maxHeight("odin", "dva", width = maxWidth("odin", "dva", width = 3)),
            maxWidth = maxWidth("odin", "dva", width = 3),
            protocol = buildInTable(1, 2), col = counter(1))
        val table = Table(res)
        val result = table.build()
        val forAssert = listOf<String>("\n$result")
        Starter.log.info { "\n$result" }
        assertEquals(expected, forAssert)
    }
=======
package ru.bmstu.iu4.Sem04.createTable

import org.junit.Test
import ru.bmstu.iu4.Sem04.Starter
import kotlin.test.assertEquals

internal class FunctionForBuildKtTest {

    @Test
    fun newMaxHeightTest() {
        val stringTest = "123456789"
        val width = 3
        val expected = 2
        val result = stringTest.newMaxHeight(width)
        assertEquals(expected, result)
    }

    @Test
    fun adjustHeightTest() {
        val testList = listOf<String>("123 123", "456 456")
        var maxWidth: Int = 0
        for (i in 0..testList.lastIndex) {
            val temp = testList[i].split(" ")
            for (k in 0..temp.lastIndex) { if (temp[k].length > 2) maxWidth = temp[k].length}
        }
        println(maxWidth)
    }

    @Test
    fun maxWidthTest() {
        val res = maxWidth("odineddddd", "dva", "tri3d", width = 2)
        assertEquals(10, res)
    }

    @Test
    fun maxHeightTest() {
        val r = maxHeight("ten10ten10", "eleven11111", width = 10)
        println(r)
        assertEquals(2, r)
    }

    @Test
    fun centralizationTest() {
        val temp = "center"
        val width = 7
        val test = temp.centralization(width)
        println(test)
        assertEquals(7, test.length)
    }

    @Test
    fun buildInTableTest() {
        val constructorCase = Array(3) { Array(3) { 0 } }
        constructorCase[0] = arrayOf(1, 2, 2)
        constructorCase[1] = arrayOf(3, 4, 4)
        constructorCase[2] = arrayOf(3, 4, 4)
        val test = buildInTable(3, 3)
        for (i in 0..2) {
            println(test[0][i])
            println(test[1][i])
            println(test[2][i])
        }
        assertEquals(constructorCase, test)
        //я не знаю почему этот тест показывает ошибку :(
    }

    @Test
    fun counterTest() {
        val expected = listOf<Int>(0, 1, 2)
        val result = counter(3)
        assertEquals(expected, result)
    }

    @Test
    fun tableTest() {
        val expected = mutableListOf<String>()
        expected.add("\n|----|----|\n|odin| dva|\n|    |    |\n|----|----|")

        val res = Row("odin", "dva", width = 3, height = 1, maxHeight = maxHeight("odin", "dva", width = maxWidth("odin", "dva", width = 3)),
            maxWidth = maxWidth("odin", "dva", width = 3),
            protocol = buildInTable(1, 2), col = counter(1))
        val table = Table(res)
        val result = table.build()
        val forAssert = listOf<String>("\n$result")
        Starter.log.info { "\n$result" }
        assertEquals(expected, forAssert)
    }
>>>>>>> master
}