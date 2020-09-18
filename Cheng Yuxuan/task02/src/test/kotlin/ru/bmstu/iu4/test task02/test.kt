package ru.bmstu.iu4.`test task02`

import org.junit.Test
import ru.bmstu.iu4.task02.*
import kotlin.test.assertEquals

internal class vectorTest {
    @Test
    fun VectorPlus() {
        val Vector1: Vector = listOf(1f, 5f, 9f)
        val Vector2: Vector = listOf(1f, 5f, 9f)
        val VectorSum = Vector1 + Vector2
        val result: Vector = listOf(2f, 10f, 18f)
        assertEquals(result, VectorSum, "Plus Error")
    }

    @Test
    fun VectorMinus() {
        val Vector1: Vector = listOf(1f, 5f, 9f)
        val Vector2: Vector = listOf(1f, 5f, 9f)
        val VectorMin = Vector1 - Vector2
        val result: Vector = listOf(0f, 0f, 0f)
        assertEquals(result, VectorMin, "Minus Error")
    }

    @Test
    fun VectorEqualsTrue() {
        val Vector1: Vector = listOf(1f, 5f, 9f)
        val Vector2: Vector = listOf(1f, 5f, 9f)
        val result = Vector1.equals(Vector2)
        assertEquals(true, result, "Equals True Error")
    }

    @Test
    fun VectorEqualsFalse() {
        val Vector1: Vector = listOf(1f, 5f, 9f)
        val Vector2: Vector = listOf(1f, 6f, 6f)
        val result = Vector1.equals(Vector2)
        assertEquals(false, result, "Equals False Error")
    }

    @Test
    fun VectorDot() {
        val Vector1: Vector = listOf(1f, 3f, 6f)
        val Vector2: Vector = listOf(1f, 2f, 3f)
        val result = Vector1 dot Vector2
        assertEquals(25f, result, "Dot False Error")
    }

    @Test
    fun VectorCross() {
        val Vector1: Vector = listOf(1f, 3f, 6f)
        val Vector2: Vector = listOf(1f, 2f, 3f)
        val result = listOf<Float>(-3f, 3f, -1f)

        assertEquals(result, Vector1 cross Vector2)
    }
}
internal class matFuncsTest {
@Test
fun matrix2DPlus(){
    val matrix2D1: Matrix2D = listOf(listOf(1F, 2F, 3F),
        listOf(5F, 6F, 7F),
        listOf(10F, 15F, 20F))
    val matrix2D2: Matrix2D = listOf(listOf(0F, 1F, 2F),
        listOf(3F, 4F, 5F),
        listOf(3F, 6F, 9F))
    val matrix2DSum = matrix2D1 + matrix2D2
    val result: Matrix2D = listOf(listOf(1F, 3F, 5F),
        listOf(8F, 10F, 12F),
        listOf(13F, 21F, 29F))
    assertEquals(result, matrix2DSum)
}

@Test
fun matrix2DMinus(){
    val matrix2D1: Matrix2D = listOf(listOf(1F, 2F, 3F),
        listOf(5F, 6F, 7F),
        listOf(10F, 15F, 20F))
    val matrix2D2: Matrix2D = listOf(listOf(0F, 1F, 2F),
        listOf(3F, 4F, 5F),
        listOf(3F, 6F, 9F))
    val matrix2DMin = matrix2D1 - matrix2D2
    val result: Matrix2D = listOf(listOf(1F, 1F, 1F),
        listOf(2F, 2F, 2F),
        listOf(7F, 9F, 11F))
    assertEquals(result, matrix2DMin)
}

@Test
fun matrix2DMultiplication(){
    val matrix2D1: Matrix2D = listOf(listOf(-1F, 1F),
        listOf(2F, 0F),
        listOf(0F, 3F))
    val matrix2D2: Matrix2D = listOf(listOf(1F, 2F, 3F),
        listOf(0F, -1F, -2F))
    val matrix2DMul = matrix2D1 * matrix2D2
    val result: Matrix2D = listOf(listOf(-1F, -3F, -5F),
        listOf(2F, 4F, 6F),
        listOf(0F, -3F, -12F))
    assertEquals(result, matrix2DMul)
}

@Test
fun matrix2DTransposeEqualTest(){
    val matrix2D: Matrix2D = listOf(listOf(4F, 3F, 2F),
        listOf(1F, 0F, -1F))
    val result: Matrix2D = listOf(listOf(1F, 2F),
        listOf(3F, 4F),
    listOf(5F, 6F))
    assertEquals(result, matrix2D.transpose())
}

@Test
fun matrix2DCrossVectorEqualTest(){
    val matrix2D: Matrix2D = listOf(listOf(2F, 4F, 6F),
        listOf(-1F, 1F, 2F),
        listOf(-1F, 0F, 1F))
    val vector: Vector = listOf(1F, 2F, 3F)
    val result = listOf(listOf(28F), listOf(7F), listOf(-2F))
    assertEquals(result, matrix2D crossVector vector)
}
}