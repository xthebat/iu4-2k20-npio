package ru.bmstu.iu4

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Tests {
    @Test
    fun testCountSumm() {
        val mapper = jacksonObjectMapper()
        val persons = File("generated.json").readText()
        val info1: Persons = mapper.readValue(persons, Persons::class.java)
        val summ = countCache(info1)
        println(summ)
        assertEquals(summ, 29373.470092773438)
        //assertEquals(summ, 107436.20025634766)
    }
}