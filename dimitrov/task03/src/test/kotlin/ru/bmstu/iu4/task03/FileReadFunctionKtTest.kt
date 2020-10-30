package ru.bmstu.iu4.task03

import org.junit.Test
import ru.inforion.lab403.common.extensions.toFile
import kotlin.test.assertEquals

internal class FileReadFunctionKtTest {

    @Test
    fun sumBalanceTest() {
        val loadFile = "C:/Users/dimit/OneDrive/Документы/generated.json"
        val functionGlobal = loadPersonFromFile(loadFile.toFile())
        val testBalance: Float = 59906.926f
        val testBalance2 = sumBalance(functionGlobal, loadFile)
        assertEquals(testBalance, testBalance2)
    }
}