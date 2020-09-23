package ru.bmstu.iu4.task03

import org.junit.Test
import ru.bmstu.iu4.task03.Parser.calculator
import ru.bmstu.iu4.task03.Parser.converter
import kotlin.test.assertEquals

internal class ParserTest {

    @Test
    fun TestConverter() {
        val source = "$1,161.11"
        val res = 1161.11F
        assertEquals(res, converter(source))
    }


    @Test
    fun TestCalculator() {
        val path = "..\\..\\files\\task03\\generated.json"
        val data = Parser.personsParser(path)
        val res = calculator(data)
        assertEquals(41190.4F, res)
    }
}