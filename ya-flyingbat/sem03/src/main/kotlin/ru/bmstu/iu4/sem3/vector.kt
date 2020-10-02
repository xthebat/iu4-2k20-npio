package ru.bmstu.iu4.sem3

typealias Vector = Array<Float>

/**
 * Adding two vectors
 */
operator fun Vector.plus(other: Vector): Vector {
    require(size == other.size) { "Vectors size must be equal" }
    return zip(other).map { it.first + it.second }.toTypedArray()
}

/**
 * Subtracting one vector from another
 */
operator fun Vector.minus(other: Vector): Vector {
    require(size == other.size) { "Vectors size must be equal" }
    return zip(other).map { it.first - it.second }.toTypedArray()
}

/**
 * Dot product of two vectors
 */
infix fun Vector.dot(other: Vector): Float {
    require(size == other.size) { "Vectors size must be equal" }
    return zip(other).fold(0F) { acc, it -> acc + it.first * it.second }
}