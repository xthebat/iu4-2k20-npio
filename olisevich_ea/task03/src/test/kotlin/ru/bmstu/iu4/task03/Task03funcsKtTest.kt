package ru.bmstu.iu4.task03

import org.junit.Test
import java.util.regex.Pattern
import kotlin.math.exp
import kotlin.test.assertEquals

internal class Task03funcsKtTest {

    @Test
    fun initCellConfigTest() {
        val conf: ConfigRow = initRow("name age", 2).bBotDel().bLeftDel().bRightDel().bTopDel()
        val actual: ConfigRow = ConfigRow(listOf("name", "age"), 2)
        actual.bot = false;
        actual.top = false;
        actual.left = false;
        actual.right = false;
        assertEquals(conf, actual)
    }

    @Test
    fun makeCellTest(){
        val cell: Cell = initRow("hi", 5).buildCell("hi")
        val expected: Cell = mutableListOf(
            mutableListOf(LineTypes.NN.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.NN.ch),
            mutableListOf(LineTypes.VS.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
            mutableListOf(LineTypes.VS.ch, LineTypes.NN.ch, "h", "i", LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
            mutableListOf(LineTypes.VS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.VS.ch)

        )

        assertEquals(cell, expected)
    }

    @Test
    fun makeRowTest(){
        val row: Row =  initRow("hi wrld", 8).buildRow()
        val expected: Row = mutableListOf(
            mutableListOf(
                mutableListOf(LineTypes.NN.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.NN.ch),
                mutableListOf(LineTypes.VS.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                mutableListOf(LineTypes.VS.ch, LineTypes.NN.ch, "h", "i", LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                mutableListOf(LineTypes.VS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.VS.ch)

            ),
            mutableListOf(
                mutableListOf(LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.NN.ch),
                mutableListOf(LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                mutableListOf(LineTypes.NN.ch, "w", "r", "l", "d", LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                mutableListOf(LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.VS.ch)

            )
        )

        assertEquals(row, expected)
    }

    @Test
    fun makeTableTest(){
        val tab = createTable("hi wrld", 8).rowAdd("its me").initTable()
        val expected: Table = mutableListOf(

            mutableListOf(
                mutableListOf(
                    mutableListOf(LineTypes.NN.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.NN.ch),
                    mutableListOf(LineTypes.VS.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                    mutableListOf(LineTypes.VS.ch, LineTypes.NN.ch, "h", "i", LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                    mutableListOf(LineTypes.VS.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch)

                ),
                mutableListOf(
                    mutableListOf(LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.NN.ch),
                    mutableListOf(LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                    mutableListOf(LineTypes.NN.ch, "w", "r", "l", "d", LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                    mutableListOf(LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch)

                )
            ),
            mutableListOf(
                mutableListOf(
                    mutableListOf(LineTypes.NN.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.NN.ch),
                    mutableListOf(LineTypes.VS.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                    mutableListOf(LineTypes.VS.ch, LineTypes.NN.ch, "i", "t", "s", LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                    mutableListOf(LineTypes.VS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.VS.ch)

                ),
                mutableListOf(
                    mutableListOf(LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.NN.ch),
                    mutableListOf(LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                    mutableListOf(LineTypes.NN.ch, "m", "e", LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.NN.ch, LineTypes.VS.ch),
                    mutableListOf(LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.HS.ch, LineTypes.VS.ch)

                )
            )
        )

        assertEquals(expected, tab)

    }


}