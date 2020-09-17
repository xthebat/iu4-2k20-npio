package ru.bmstu.iu4

fun Matrix.init() {
    val rows = this.size
    val cols = this[0].size
    if (this[rows - 1][cols - 1] != null) {
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                this[i][j] = (0 until 10).random()
            }
        }
    }
}

fun Matrix.print() {
    val rows = this.size
    val cols = this[0].size
    if (this[rows - 1][cols - 1] != null) {
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                print(this[i][j])
                print(" ")
            }
            println()
        }
    }
}

fun Matrix.summ(matrix1: Matrix, matrix2: Matrix) {
    val rows1 = matrix1.size
    val cols1 = matrix1[0].size
    val rows2 = matrix2.size
    val cols2 = matrix2[0].size

    if (rows1 == rows2 && cols1 == cols2) {
        if (matrix1[rows1 - 1][cols1 - 1] != null) {
            for (i in 0 until rows1) {
                for (j in 0 until cols1) {
                    this[i][j] = matrix1[i][j] + matrix2[i][j]
                }
            }
        }
    }
}

fun Matrix.subtr(matrix1: Matrix, matrix2: Matrix) {
    val rows1 = matrix1.size
    val cols1 = matrix1[0].size
    val rows2 = matrix2.size
    val cols2 = matrix2[0].size

    if (rows1 == rows2 && cols1 == cols2) {
        if (matrix1[rows1 - 1][cols1 - 1] != null) {
            for (i in 0 until rows1) {
                for (j in 0 until cols1) {
                    this[i][j] = matrix1[i][j] - matrix2[i][j]
                }
            }
        }
    }
}

fun Matrix.dotMult(matrix1: Matrix, matrix2: Matrix) {
    val rows1 = matrix1.size
    val cols1 = matrix1[0].size
    val rows2 = matrix2.size
    val cols2 = matrix2[0].size

    if (rows1 == rows2 && cols1 == cols2) {
        if (matrix1[rows1 - 1][cols1 - 1] != null) {
            for (i in 0 until rows1) {
                for (j in 0 until cols1) {
                    this[i][j] = matrix1[i][j] * matrix2[i][j]
                }
            }
        }
    }
}

fun Matrix.crossMult(matrix1: Matrix, matrix2: Matrix) {
    val rows1 = matrix1.size
    val cols1 = matrix1[0].size
    val rows2 = matrix2.size
    val cols2 = matrix2[0].size

    if (cols1 == rows2) {
        for (i in 0 until rows1) {
            for (j in 0 until cols2) {
                this[i][j] = 0
                for (k in 0 until cols1) {
                    this[i][j] += matrix1[i][k] * matrix2[k][j]
                }
            }
        }
    }
}

fun Matrix.transp(): Matrix {
    val rows1 = this.size
    val cols1 = this[0].size

    val tmp: Matrix = MutableList(cols1, { MutableList(rows1, { 0 }) })

    for (i in 0..tmp.size - 1) {
        for (j in 0..tmp[0].size - 1) {
            tmp[i][j] = this[j][i]
        }
    }

    return tmp
}