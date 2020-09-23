package ru.bmstu.iu4.task01

import org.junit.Before
import org.junit.Test
import ru.inforion.lab403.common.logging.logger
import kotlin.test.assertEquals
import kotlin.test.assertFails

internal class T1funcsKtTest {

    val log = logger();

    @Before
    fun BeforeTest() {
        log.config { "Start next test..." };
    }

    @Test
    fun qSort() {
        log.config{ "Start qSort test..."};

        var testar1: ArrayList<Int> = arrayListOf( 1 , 0 , 0 , 0 , 0);
        qSort(testar1);
        assertEquals(arrayListOf( 0 , 0 , 0 , 0 , 1), testar1 );
    }

    @Test
    fun qSortNotEmpty() {
        log.config{ "Start qSort empty test..."};

        var testar: ArrayList<Int> = arrayListOf();
        assertFails { qSort(testar) };
    }


    @Test
    fun arSwap() {
        log.config{ "Start arSwap test..."};
        var inpar: ArrayList<Int> = arrayListOf( 10, 5 );
        arSwap(inpar, 0, 1);
        assertEquals(inpar, arrayListOf(5, 10));
    }
}