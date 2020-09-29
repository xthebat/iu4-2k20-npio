package ru.bmstu.iu4.uzenkovD.task01.helloWorld

import org.junit.Test
import ru.inforion.lab403.common.logging.logger
import kotlin.test.assertEquals
import kotlin.test.assertFails


internal class FizzBuzzFunctionsKtTest {

    private val log = logger()

    @Test
    fun convertStrings2IntsValidTest() {
        log.config { "Starting convert valid test..." }
        val args = arrayOf("1", "0", "4", "5", "1929292", "0122", "354")
        assertEquals(listOf(1, 0, 4, 5, 1929292, 122, 354), convertStrings2Ints(args))
    }

    @Test
    fun convertStrings2IntsInvalidTest() {
        log.config { "Starting convert invalid test..." }
        val args = arrayOf("1", "0", "4", "5", "LOL", "0122", "354")
        assertFails { convertStrings2Ints(args) }
    }

    @Test
    fun minNotEmptyTest() {
        log.config { "Starting min not empty test..." }
        val list = listOf(10, 3, 1, 4, 7, 2)
        assertEquals(10, max(list))
    }

    @Test
    fun minEmptyTest() {
        log.config { "Starting min empty test..." }
        val list = emptyList<Int>()
        assertFails { min(list) }
    }

    @Test
    fun maxNotEmptyTest() {
        log.config { "Starting max not empty test..." }
        val list = listOf(10, 3, 1, 4, 7, 2)
        assertEquals(1, min(list))
    }

    @Test
    fun maxEmptyTest() {
        log.config { "Starting max empty test..." }
        val list = emptyList<Int>()
        assertFails { max(list) }
    }

    @Test
    fun fizzbuzz() {

    }

    @Test
    fun countTest() {
        log.config { "Starting count test..." }
        assertEquals(5, count("lold-filllves", 'l'))
        assertEquals(1, count("loldfilllves", 'd'))
        assertEquals(0, count("loldfilllves", ' '))
        assertEquals(0, count("", ' '))
        assertEquals(1, count("lold filllves", ' '))
        assertEquals(2, count("loFd Filllves", 'F'))
    }

    @Test
    fun fizzbuzzplayTest() {
        log.config { "Starting fizzbuzz play test..." }
        assertEquals(5, play(1, 1, 'u'))
        assertEquals(10, play(1, 2, 'u'))
        assertEquals(15, play(1, 3, 'u'))
    }
}
