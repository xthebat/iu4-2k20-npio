
import org.junit.Test
import ru.bmstu.iu4.sort
import kotlin.test.assertEquals

internal class Test {

    @Test
    fun sortTest() {

        val sortArray = intArrayOf(11, 2, 7, 5, 3, 0, 9, 16)
        val rightArray= intArrayOf(0, 2, 3, 5, 7, 9, 11, 16)
        val resultArray= sort(sortArray, 0, sortArray.size - 1)
        assertEquals(resultArray,rightArray)
    }
}
