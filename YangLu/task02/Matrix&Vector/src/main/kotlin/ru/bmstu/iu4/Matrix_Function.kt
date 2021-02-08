<<<<<<< HEAD
package ru.bmstu.iu4

open class Matrix(
    val rows: Int,
    val cols: Int,
    val components : DoubleArray =  DoubleArray(cols * rows)
) {

    constructor(rows: Int, cols: Int, matrixMapper: (Int, Int) -> Double) : this(rows, cols) {
        for(r in 0 until rows){
            for(c in 0 until cols){
                set(r, c, matrixMapper.invoke(r, c))
            }
        }
    }

    fun get(row: Int, col: Int) = components[(row * cols) + col]

    fun set(row: Int, col: Int, value: Double) { components[(row * cols) + col] = value }

    operator fun get(i: Int) = components[i]

    operator fun set(i: Int, value: Double) { components[i] = value }

    operator fun plus(other: Matrix) = Matrix(rows, cols) { r, c -> get(r, c) + other.get(r, c) }

    operator fun minus(other: Matrix) = Matrix(rows, cols) { r, c -> get(r, c) - other.get(r, c) }

    operator fun times(vector: Vector): Vector {

        if(vector.size != cols)
            throw IncorrectDimensions()

        val result = Vector(rows)

        for(rowA in 0 until this.rows){

            val rowOffsetA = (rowA * this.cols)
            var valueC = 0.0

            for(i in 0 until vector.size){

                val valueB = vector[i]
                val valueA = this[rowOffsetA + i]
                valueC += (valueA * valueB)
            }

            result[rowA] = valueC
        }

        return result
    }

    operator fun plusAssign(other: Matrix) {
        for(r in 0 until rows){
            for(c in 0 until cols){
                set(r, c, get(r, c) + other.get(r, c))
            }
        }
    }

    operator fun minusAssign(other: Matrix) {
        for(r in 0 until rows){
            for(c in 0 until cols){
                set(r, c, get(r, c) - other.get(r, c))
            }
        }
    }

    operator fun times(other: Matrix): Matrix {
        val A = this
        val B = other
        val C = Matrix(A.rows, B.cols)
        for(rowA in 0 until A.rows){

            val rowOffsetA = (rowA * A.cols)

            for(colB in 0 until B.cols){

                var valueC = 0.0

                for(colA in 0 until A.cols){
                    val rowOffsetB = (colA * B.cols)
                    val valueB = B[rowOffsetB + colB]
                    val valueA = A[rowOffsetA + colA]
                    valueC += (valueA * valueB)
                }

                C.set(rowA, colB, valueC)
            }
        }
        return C
    }

    operator fun times(scalar: Double) = Matrix(rows, cols) { r, c -> get(r, c) * scalar }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Matrix) return false

        if (rows != other.rows) return false
        if (cols != other.cols) return false
        if (!components.contentEquals(other.components)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rows
        result = 31 * result + cols
        result = 31 * result + components.contentHashCode()
        return result
    }
=======
package ru.bmstu.iu4

open class Matrix(
    val rows: Int,
    val cols: Int,
    val components : DoubleArray =  DoubleArray(cols * rows)
) {

    constructor(rows: Int, cols: Int, matrixMapper: (Int, Int) -> Double) : this(rows, cols) {
        for(r in 0 until rows){
            for(c in 0 until cols){
                set(r, c, matrixMapper.invoke(r, c))
            }
        }
    }

    fun get(row: Int, col: Int) = components[(row * cols) + col]

    fun set(row: Int, col: Int, value: Double) { components[(row * cols) + col] = value }

    operator fun get(i: Int) = components[i]

    operator fun set(i: Int, value: Double) { components[i] = value }

    operator fun plus(other: Matrix) = Matrix(rows, cols) { r, c -> get(r, c) + other.get(r, c) }

    operator fun minus(other: Matrix) = Matrix(rows, cols) { r, c -> get(r, c) - other.get(r, c) }

    operator fun times(vector: Vector): Vector {

        if(vector.size != cols)
            throw IncorrectDimensions()

        val result = Vector(rows)

        for(rowA in 0 until this.rows){

            val rowOffsetA = (rowA * this.cols)
            var valueC = 0.0

            for(i in 0 until vector.size){

                val valueB = vector[i]
                val valueA = this[rowOffsetA + i]
                valueC += (valueA * valueB)
            }

            result[rowA] = valueC
        }

        return result
    }

    operator fun plusAssign(other: Matrix) {
        for(r in 0 until rows){
            for(c in 0 until cols){
                set(r, c, get(r, c) + other.get(r, c))
            }
        }
    }

    operator fun minusAssign(other: Matrix) {
        for(r in 0 until rows){
            for(c in 0 until cols){
                set(r, c, get(r, c) - other.get(r, c))
            }
        }
    }

    operator fun times(other: Matrix): Matrix {
        val A = this
        val B = other
        val C = Matrix(A.rows, B.cols)
        for(rowA in 0 until A.rows){

            val rowOffsetA = (rowA * A.cols)

            for(colB in 0 until B.cols){

                var valueC = 0.0

                for(colA in 0 until A.cols){
                    val rowOffsetB = (colA * B.cols)
                    val valueB = B[rowOffsetB + colB]
                    val valueA = A[rowOffsetA + colA]
                    valueC += (valueA * valueB)
                }

                C.set(rowA, colB, valueC)
            }
        }
        return C
    }

    operator fun times(scalar: Double) = Matrix(rows, cols) { r, c -> get(r, c) * scalar }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Matrix) return false

        if (rows != other.rows) return false
        if (cols != other.cols) return false
        if (!components.contentEquals(other.components)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rows
        result = 31 * result + cols
        result = 31 * result + components.contentHashCode()
        return result
    }
>>>>>>> master
}