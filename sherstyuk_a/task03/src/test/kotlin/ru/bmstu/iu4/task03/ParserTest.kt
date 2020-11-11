<<<<<<< HEAD
package ru.bmstu.iu4.task03

import org.junit.Test
import ru.bmstu.iu4.task03.Parser.calcBalanceByAge
import ru.bmstu.iu4.task03.Parser.converter
import kotlin.test.assertEquals

internal class ParserTest {

    @Test
    fun TestConverter() {
        val source = "$1,161.11"
        val res = 1161.11
        assertEquals(res, source.converter())
    }


    @Test
    fun TestCalculator() {
        val path = "..\\..\\files\\task03\\generated.json"
        val data = Parser.personsParser(path)
        val res = data.calcBalanceByAge(20 ,30)
        assertEquals(41190.40, res)
    }
=======
package ru.bmstu.iu4.task03

import org.junit.Test
import ru.bmstu.iu4.task03.Parser.calcBalanceByAge
import ru.bmstu.iu4.task03.Parser.converter
import kotlin.test.assertEquals

internal class ParserTest {

    @Test
    fun TestConverter() {
        val source = "$1,161.11"
        val res = 1161.11
        assertEquals(res, source.converter())
    }


    @Test
    fun TestCalculator() {
        val path = "..\\..\\files\\task03\\generated.json"
        val data = Parser.personsParser(path)
        val res = data.calcBalanceByAge(20 ,30)
        assertEquals(41190.40, res)
    }
>>>>>>> master
}