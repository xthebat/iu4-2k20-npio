import com.korchagin.task01.quicksort
import org.junit.Test
import kotlin.test.assertEquals

internal class QSortKtTest {

    @Test
    fun quicksort() {
        var numbers = listOf<Int>(2, 4, 7, 3, 6, 9, 5, 1, 0)
        var check = listOf<Int>(0, 1, 2, 3, 4, 5, 6, 7, 9)
        assertEquals(quicksort(numbers), check)
        numbers = listOf(2, 1)
        check = listOf(1, 2)
        assertEquals(quicksort(numbers), check)
    }
}