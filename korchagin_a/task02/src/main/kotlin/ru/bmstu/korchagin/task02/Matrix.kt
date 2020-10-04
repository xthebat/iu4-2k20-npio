package ru.bmstu.korchagin.task02

//Vector, Matrix2D
//- +, -, ==, *, *= ....  plus, minus, equals, ....
//- dot, cross, transpose  (vector dot vector, matrix dot matrix, matrix cross vector, vector cross vector)
//- cross - матричное перемножение
//- dot - скалярное
//List<Float>
//List<List<Float>>
//
//- typealias
//        - operator
//
//        - unittest

//typealias Matrix = List<List<Float>>
//typealias Vector = List<Float>

operator fun Matrix.plus(matrix: Matrix): Matrix{
    var output = mutableListOf<List<Float>>();
    if (checkMatrix(this) && checkMatrix(matrix) && this.size == matrix.size && this.get(0).size == matrix.get(0).size){
        for (i in 0 until this.size){
            var vector = mutableListOf<Float>()
            for (j in 0 until this.get(i).size){
                vector.add(this.get(i)[j] + matrix.get(i)[j])
            }
            output.add(vector)
        }
        return output
    }
    return listOf(listOf(0F), listOf(0F), listOf(0F))
}

operator fun Matrix.minus(matrix: Matrix): Matrix{
    var output = mutableListOf<List<Float>>();
    if (checkMatrix(this) && checkMatrix(matrix) && this.size == matrix.size && this.get(0).size == matrix.get(0).size){
        for (i in 0 until this.size){
            var vector = mutableListOf<Float>()
            for (j in 0 until this.get(i).size){
                vector.add(this.get(i)[j] - matrix.get(i)[j])
            }
            output.add(vector)
        }
        return output
    }
    return listOf(listOf(0F), listOf(0F), listOf(0F))
}

operator fun Matrix.times(matrix: Matrix): Matrix{
    println("OK")
    var output = mutableListOf<List<Float>>()
    if (checkMatrix(this) && checkMatrix(matrix) && this.get(0).size == matrix.size){
        val M = this.size
        val N = matrix.get(0).size
        val K = matrix.size
        for (i in 0 until M){
            var vector = mutableListOf<Float>()
            for (j in 0 until N){
                vector.add(0F)
                for (k in 0 until K){
                    vector.set(j, vector.get(j) + this[i][k] * matrix[k][j])
                }
            }
            output.add(vector)
        }
    }
    return output
}

infix fun Matrix.equals(matrix: Matrix): Boolean{
    if (checkMatrix(this) && checkMatrix(matrix) && this.size == matrix.size && this[0].size == matrix[0].size){
        val M = this.size
        val N = this.get(0).size
        for (i in 0 until M){
            for (j in 0 until N){
                if (this[i][j] != matrix[i][j]){
                    return false
                }
            }
        }
        return true
    }
    return false
}

fun Matrix.transonse(): Matrix{
    var output = mutableListOf<List<Float>>()
    if (checkMatrix(this)){
        val M = this.size
        val N = this[0].size
        for (i in 0 until N){
            var vector = mutableListOf<Float>()
            for (j in 0 until M) {
                vector.add(this[j][i])
            }
            output.add(vector)
        }
    }
    return output
}


fun checkMatrix(matrix: Matrix): Boolean{
    var size = matrix.get(0).size
    for(i in 1 until matrix.size){
        if (matrix.get(i).size != size){
            return false
        }
    }
    return true
}