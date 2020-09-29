package ru.bmstu.iu4.task03

import org.junit.Test
import ru.bmstu.iu4.task03.LineTypes.*
import kotlin.test.assertEquals

internal class Task03funcsKtTest {

    @Test
    fun makeCellTest(){
        val actual: Cell = listOf("hi").toRow(5, 1).single()
        val expected: Cell = mutableListOf(
            mutableListOf(NN.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, NN.ch),
            mutableListOf(VS.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
            mutableListOf(VS.ch, NN.ch, "h ", "i ", NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
            mutableListOf(VS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, VS.ch)
        )

        println(actual.stringify())

        expected.zip(actual).forEach { assertEquals(it.first, it.second) }
    }

    @Test
    fun makeRowTest(){
        val row: Row =  listOf("hi wrld").toRow(2,8)
        val expected: Row = mutableListOf(
            mutableListOf(
                mutableListOf(NN.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, NN.ch),
                mutableListOf(VS.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                mutableListOf(VS.ch, NN.ch, "h", "i", NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                mutableListOf(VS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, VS.ch)
            ),
            mutableListOf(
                mutableListOf(HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, NN.ch),
                mutableListOf(NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                mutableListOf(NN.ch, "w", "r", "l", "d", NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                mutableListOf(HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, VS.ch)

            )
        )

        assertEquals(row, expected)
    }

    @Test
    fun makeTableTest() {

        val tab = table().also {
            it.addRow(listOf("hi", "wrld"), 8)
            it.addRow(listOf("its", "me"), 8)
        }

        val expected: Table = mutableListOf(
            mutableListOf(
                mutableListOf(
                    mutableListOf(NN.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, NN.ch),
                    mutableListOf(VS.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                    mutableListOf(VS.ch, NN.ch, "h", "i", NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                    mutableListOf(VS.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch)

                ),
                mutableListOf(
                    mutableListOf(HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, NN.ch),
                    mutableListOf(NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                    mutableListOf(NN.ch, "w", "r", "l", "d", NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                    mutableListOf(NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch)

                )
            ),
            mutableListOf(
                mutableListOf(
                    mutableListOf(NN.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, NN.ch),
                    mutableListOf(VS.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                    mutableListOf(VS.ch, NN.ch, "i", "t", "s", NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                    mutableListOf(VS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, VS.ch)
                ),
                mutableListOf(
                    mutableListOf(HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, NN.ch),
                    mutableListOf(NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                    mutableListOf(NN.ch, "m", "e", NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, NN.ch, VS.ch),
                    mutableListOf(HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, HS.ch, VS.ch)
                )
            )
        )

        assertEquals(expected, tab)

    }


}