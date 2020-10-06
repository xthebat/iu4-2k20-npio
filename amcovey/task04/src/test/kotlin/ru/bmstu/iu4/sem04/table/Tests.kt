package ru.bmstu.iu4.sem04.table

import org.junit.Test
import ru.inforion.lab403.common.logging.logger
import kotlin.test.assertEquals


internal class Tests {
    companion object {
        val log = logger()
    }

    @Test
    fun buildCellTest() {
        val text = Cell("MyCeeeell", 15, 5).apply {
            top = true
            bottom = true
            left = true
            right = true
            horizontalEdge = '|'
            centerAlign = false
        }
        val result = """
                        |---------------|
                        |               |
                        |               |
                        |MyCeeeell      |
                        |               |
                        |               |
                        |---------------|
        """.trimIndent()
        val testCell = text.build()
        log.info { "\n$testCell" }
        assertEquals(result, testCell)

        val textCenter = Cell("MyCeeeell", 15, 5).apply {
            top = true
            bottom = true
            left = true
            right = true
            horizontalEdge = '|'
            centerAlign = true
        }
        val resultCenter = """
                        |---------------|
                        |               |
                        |               |
                        |   MyCeeeell   |
                        |               |
                        |               |
                        |---------------|
        """.trimIndent()
        val testCellCenter = textCenter.build()
        log.info { "\n$testCellCenter" }
        assertEquals(resultCenter, testCellCenter)

        val textAdjust = Cell("MyCeeeell", 15, 5).apply {
            top = true
            bottom = true
            left = true
            right = true
            horizontalEdge = '|'
            centerAlign = true
        }
        val resultAdjust = """
                        |---------|
                        |         |
                        |         |
                        |MyCeeeell|
                        |         |
                        |         |
                        |---------|
        """.trimIndent()
        textAdjust.adjustCell(textAdjust.text.length)
        val testCellAdjust = textAdjust.build()
        log.info { "\n$testCellAdjust" }
        assertEquals(resultAdjust, testCellAdjust)

        val textCarry = Cell("MyCeeeell", 5, 5).apply {
            top = true
            bottom = true
            left = true
            right = true
            horizontalEdge = '|'
            centerAlign = true
        }
        val resultCarry = """
                            |-----|
                            |     |
                            |     |
                            |MyCee|
                            |eell |
                            |     |
                            |-----|
        """.trimIndent()
        val testCarry = textCarry.build()
        log.info { "\n$testCarry" }
        assertEquals(resultCarry, testCarry)
    }

    @Test
    fun buildRowTest() {
        val text = Row("first", "second", "third", "12345678901234567890", width = 15, height = 5).apply {
            rowBottom = true
            rowTop = true
            doubleFrames = false
        }
        val testRow = text.build()
        val result = """
                        |---------------|---------------|---------------|---------------|
                        |               |               |               |               |
                        |               |               |               |               |
                        |     first     |    second     |     third     |123456789012345|
                        |               |               |               |67890          |
                        |               |               |               |               |
                        |---------------|---------------|---------------|---------------|
        """.trimIndent()
        assertEquals(result, testRow)
        log.info { "\n$testRow" }

        val textFrames = Row("first", "second", "third", "12345678901234567890", width = 15, height = 5).apply {
            rowBottom = true
            rowTop = true
            doubleFrames = true
        }
        val testRowFrames = textFrames.build()
        val resultFrames = """
                            |---------------||---------------||---------------||---------------|
                            |               ||               ||               ||               |
                            |               ||               ||               ||               |
                            |     first     ||    second     ||     third     ||123456789012345|
                            |               ||               ||               ||67890          |
                            |               ||               ||               ||               |
                            |---------------||---------------||---------------||---------------|
        """.trimIndent()
        assertEquals(resultFrames, testRowFrames)
        log.info { "\n$testRowFrames" }

    }

    @Test
    fun buildTableTest() {
        val text = Table(
                Row("One", "TwoTwo", "Free", "FourFour", width = 15, height = 5),
                Row("FiveFive", "SixSixSix", "SevenSevenSevenSevenSeven", "Eight", width = 15, height = 5),
                Row("Nine", "TenTenTen", "Eleven", "Twelve", width = 15, height = 5)
        ).apply { tableDoubleFrames = false }
        val resultTable = """
                            |---------------|---------------|---------------|---------------|
                            |               |               |               |               |
                            |               |               |               |               |
                            |      One      |    TwoTwo     |     Free      |   FourFour    |
                            |               |               |               |               |
                            |               |               |               |               |
                            |---------------|---------------|---------------|---------------|
                            |               |               |               |               |
                            |               |               |               |               |
                            |   FiveFive    |   SixSixSix   |SevenSevenSeven|     Eight     |
                            |               |               |SevenSeven     |               |
                            |               |               |               |               |
                            |---------------|---------------|---------------|---------------|
                            |               |               |               |               |
                            |               |               |               |               |
                            |     Nine      |   TenTenTen   |    Eleven     |    Twelve     |
                            |               |               |               |               |
                            |               |               |               |               |
                            |---------------|---------------|---------------|---------------|""".trimIndent()
        val testTable = text.build()
        assertEquals(resultTable, testTable)
        log.info { "\n$testTable" }

        val textAdjust = Table(
                Row("One", "TwoTwo", "Free", "FourFour", width = 15, height = 5),
                Row("FiveFive", "SixSixSix", "SevenSevenSevenSevenSeven", "Eight", width = 15, height = 5),
                Row("Nine", "TenTenTen", "Eleven", "Twelve", width = 15, height = 5)
        ).apply { tableDoubleFrames = false }
        val resultTableAdjust = """
                                    |---------|----------|--------------------------|---------|
                                    |         |          |                          |         |
                                    |         |          |                          |         |
                                    |   One   |  TwoTwo  |           Free           |FourFour |
                                    |         |          |                          |         |
                                    |         |          |                          |         |
                                    |---------|----------|--------------------------|---------|
                                    |         |          |                          |         |
                                    |         |          |                          |         |
                                    |FiveFive |SixSixSix |SevenSevenSevenSevenSeven |  Eight  |
                                    |         |          |                          |         |
                                    |         |          |                          |         |
                                    |---------|----------|--------------------------|---------|
                                    |         |          |                          |         |
                                    |         |          |                          |         |
                                    |  Nine   |TenTenTen |          Eleven          | Twelve  |
                                    |         |          |                          |         |
                                    |         |          |                          |         |
                                    |---------|----------|--------------------------|---------|""".trimIndent()
        textAdjust.adjustTable()
        val testTableAdjust = textAdjust.build()
        assertEquals(resultTableAdjust, testTableAdjust)
        log.info { "\n$testTableAdjust" }

        val textFrames = Table(
                Row("One", "TwoTwo", "Free", "FourFour", width = 15, height = 5),
                Row("FiveFive", "SixSixSix", "SevenSevenSevenSevenSeven", "Eight", width = 15, height = 5),
                Row("Nine", "TenTenTen", "Eleven", "Twelve", width = 15, height = 5)
        ).apply { tableDoubleFrames = true }
        val resultTableFrames = """
                                |---------------||---------------||---------------||---------------|
                                |               ||               ||               ||               |
                                |               ||               ||               ||               |
                                |      One      ||    TwoTwo     ||     Free      ||   FourFour    |
                                |               ||               ||               ||               |
                                |               ||               ||               ||               |
                                |---------------||---------------||---------------||---------------|
                                |---------------||---------------||---------------||---------------|
                                |               ||               ||               ||               |
                                |               ||               ||               ||               |
                                |   FiveFive    ||   SixSixSix   ||SevenSevenSeven||     Eight     |
                                |               ||               ||SevenSeven     ||               |
                                |               ||               ||               ||               |
                                |---------------||---------------||---------------||---------------|
                                |---------------||---------------||---------------||---------------|
                                |               ||               ||               ||               |
                                |               ||               ||               ||               |
                                |     Nine      ||   TenTenTen   ||    Eleven     ||    Twelve     |
                                |               ||               ||               ||               |
                                |               ||               ||               ||               |
                                |---------------||---------------||---------------||---------------|""".trimIndent()
//        textFrames.adjustTable()
        val testTableFrames = textFrames.build()
        assertEquals(resultTableFrames, testTableFrames)
        log.info { "\n$testTableFrames" }
    }
}