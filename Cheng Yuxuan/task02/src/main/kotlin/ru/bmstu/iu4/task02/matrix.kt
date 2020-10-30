package ru.bmstu.iu4.task02

typealias Matrix2D = List<Vector>

operator fun Matrix2D.plus(other: Matrix2D): Matrix2D{
    if (this.count() == other.count()) throw  Exception("Size of matrixes should be equal")
    val result = mutableListOf<Vector>()
    var row: Vector
    for (i in indices){
        row = this[i] + other[i]
        result.add(row)
    }
    return result
}

operator fun Matrix2D.minus(other: Matrix2D): Matrix2D{
    if (this.count() == other.count()) throw  Exception("Size of matrixes should be equal")
    val result = mutableListOf<Vector>()
    var row: Vector
    for (i in indices){
        row = this[i] - other[i]
        result.add(row)
    }
    return result
}

operator fun Matrix2D.times(other: Matrix2D): Matrix2D{
    if (this.count() == other.count())
        throw  Exception("Size of matrixes should be equal")
    val result = mutableListOf<Vector>()
    val transMatrix = mutableListOf<Vector>()
    val row = mutableListOf<Float>()
    for (i in other[0].indices){
        for (j in other.indices){
            row.add(other[j][i])
        }
        transMatrix.add(row.toMutableList())
        row.clear()
    }
    return result
}

fun Matrix2D.transpose(): Matrix2D{
    val transMatrix = mutableListOf<Vector>()
    val row = mutableListOf<Float>()
    for (i in this[0].indices){
        for (j in this.indices){
            row.add(this[j][i])
        }
        transMatrix.add(row.toMutableList())
        row.clear()
    }
    return transMatrix
}

infix fun Matrix2D.crossVector(other: Vector): Matrix2D {
    val result = mutableListOf<Vector>()
    val row = mutableListOf<Float>()
    for (i in indices) {
        row.add(this[i] dot other)
        result.add(row.toMutableList())
        row.clear()
    }
    return result
}