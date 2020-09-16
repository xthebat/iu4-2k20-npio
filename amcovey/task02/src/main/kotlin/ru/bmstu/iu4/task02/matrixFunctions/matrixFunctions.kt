package ru.bmstu.iu4.task02.matrixFunctions

import ru.bmstu.iu4.task02.vectorFunctions.Vector
import ru.bmstu.iu4.task02.vectorFunctions.*

typealias Matrix2D = List<Vector>
/* Adding two matrix */
operator fun Matrix2D.plus(x: Matrix2D): Matrix2D{
    if ((this.size != x.size) || (this[0].size != x[0].size)) throw  Exception("Vectors size must be equal")
    val result = mutableListOf<Vector>()
    var tmp: Vector
    for (i in indices){
        tmp = this[i] + x[i]
        result.add(tmp)
    }
    return result
}
/* Subtracting one matrix from another */
operator fun Matrix2D.minus(x: Matrix2D): Matrix2D{
    if ((this.size != x.size) || (this[0].size != x[0].size)) throw  Exception("Vectors size must be equal")
    val result = mutableListOf<Vector>()
    var tmp: Vector
    for (i in indices){
        tmp = this[i] - x[i]
        result.add(tmp)
    }
    return result
}
/* Multiplication of two matrices */
operator fun Matrix2D.times(x: Matrix2D): Matrix2D{
    if (this[0].size != x.size)
        throw  Exception("Count of rows in matrix A should be equal columns in matrix B")
    val result = mutableListOf<Vector>()
    val transMatrix = mutableListOf<Vector>()
    val tmpRow = mutableListOf<Float>()
    for (i in x[0].indices){
        for (j in x.indices){
            tmpRow.add(x[j][i])
        }
        transMatrix.add(tmpRow.toMutableList())
        tmpRow.clear()
    }

    for (i in indices){
        for (j in transMatrix.indices){
            tmpRow.add(this[i] dot transMatrix[j])
        }
        result.add(tmpRow.toMutableList())
        tmpRow.clear()
    }
    return result
}
/* Transpose Matrix */
fun Matrix2D.transpose(): Matrix2D{
    val transMatrix = mutableListOf<Vector>()
    val tmpRow = mutableListOf<Float>()
    for (i in this[0].indices){
        for (j in this.indices){
            tmpRow.add(this[j][i])
        }
        transMatrix.add(tmpRow.toMutableList())
        tmpRow.clear()
    }
    return transMatrix
}
/* Matrix cross Vector */
infix fun Matrix2D.crossVector(x: Vector): Matrix2D{
    val result = mutableListOf<Vector>()
    val tmpRow = mutableListOf<Float>()
    for (i in indices){
        tmpRow.add(this[i] dot x)
        result.add(tmpRow.toMutableList())
        tmpRow.clear()
    }
    return result
}