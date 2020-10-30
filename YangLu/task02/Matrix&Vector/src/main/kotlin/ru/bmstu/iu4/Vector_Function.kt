package ru.bmstu.iu4

class IncorrectDimensions : Exception("The provided vector dimensions are invalid")
class Vector(vararg val components: Double) {

    constructor(size: Int) : this(*DoubleArray(size))

    val size = components.size

    operator fun get(i: Int) = components[i]

    operator fun set(i: Int, value: Double) {
        components[i] = value
    }

    operator fun plus(exp: Vector): Vector {
        val C = Vector(size)
        for(i in 0 until size){
            C[i] = this[i] + exp[i]
        }
        return C
    }

    operator fun plusAssign(other: Vector) {
        if(other.size != size)
            throw IncorrectDimensions()
        for(i in 0 until  size)
            this[i] += other[i]
    }

    operator fun minus(exp: Vector): Vector {
        val C = Vector(size)
        for(i in 0 until size){
            C[i] = this[i] - exp[i]
        }
        return C
    }

    operator fun minusAssign(other: Vector){
        for(i in 0 until size){
            this[i] -= other[i]
        }
    }

    operator fun minus(x: Double): Vector {
        val C = Vector(size)
        for(i in 0 until size){
            C[i] = this[i] - x
        }
        return C
    }

    operator fun times(w: Matrix): Vector {
        if (size != w.rows)
            throw IncorrectDimensions()

        val result = Vector(w.cols)

        for (col in 0 until w.cols) {
            for (row in 0 until w.rows) {
                result[col] += (w.get(row, col) * this[row])
            }
        }
        return result
    }

    operator fun times(other: Vector): Vector {
        val C = Vector(size)
        for(i in 0 until size){
            C[i] = this[i] * other[i]
        }
        return C
    }

    operator fun times(scalar: Double): Vector {
        val C = Vector(size)
        for(i in 0 until size){
            C[i] = this[i] * scalar
        }
        return C
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vector

        if (!components.contentEquals(other.components)) return false
        if (size != other.size) return false

        return true
    }

    override fun hashCode(): Int {
        var result = components.contentHashCode()
        result = 31 * result + size
        return result
    }

    override fun toString(): String {
        return "Vector(components=${components.contentToString()}, size=$size)"
    }


}