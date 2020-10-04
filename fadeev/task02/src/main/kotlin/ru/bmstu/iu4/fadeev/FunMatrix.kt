package ru.bmstu.iu4.fadeev

/**
 * Create Matrix
 */
fun matrixNew(input: List<String>): Matrix {
    val out: Matrix = Matrix()

    for (i in input) {
        val lines: List<String> = i.split(" ")
        val col: ArrayList<Float> = arrayListOf()
        for (j in lines) {
            col.add(j.toFloat())
        }
        out.add(col)
    }
    return out
}

/**
 * Multiplication M*F
 * Increase M+M
 * Decrease M-M
 */

operator fun Matrix.times(input: Float): Matrix {
    for (i in indices)
        for (j in indices)
            this[i][j] *= input
    return this
}

operator fun Matrix.plus(input: Matrix): Matrix {
    for (i in indices)
        for (j in indices)
            this[i][j] += input[i][j]
    return this
}

operator fun Matrix.minus(input: Matrix): Matrix {
    for (i in indices)
        for (j in indices)
            this[i][j] -= input[i][j]
    return this
}

/**
 * Matrix cross Matrix 3*3 (vector-row)
 */
fun Matrix.mCrossMatrix(input: Matrix): Matrix {
    require(size == input[0].size) { "incorrect input" }
    val out = matrixNew(listOf("0 0 0", "0 0 0", "0 0 0"))

    for (i in indices) {
        for (j in input[0].indices) {
            out[i][j] = 0F
            for (k in input.indices) {
                out[i][j] += this[i][k] * input[k][j]
            }
        }
    }
    return out
}

/**
 * Matrix transpose
 */
fun Matrix.transpose(): Matrix {
    require(this.size == this[0].size) { "matrix is not square" }
    val out = matrixNew(listOf("0 0 0", "0 0 0", "0 0 0"))

    for (i in indices) {
        for (j in this[0].indices) {
            out[i][j] = 0F
            for (k in indices) {
                out[i][j] = this[j][i]
            }
        }
    }
    return out
}