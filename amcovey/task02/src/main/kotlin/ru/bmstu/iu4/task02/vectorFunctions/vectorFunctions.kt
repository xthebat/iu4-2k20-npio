package ru.bmstu.iu4.task02.vectorFunctions

typealias Vector = List<Float>

/* Adding two vectors */
operator fun Vector.plus(x: Vector): Vector {
    require(this.size == x.size) { "Vectors size must be equal" }
    val result = mutableListOf<Float>()
    for (index in indices) {
        result.add(this[index] + x[index])
    }
    return result
}

/* Subtracting one vector from another */
operator fun Vector.minus(x: Vector): Vector {
    require(this.size == x.size) { "Vectors size must be equal" }
    val result = mutableListOf<Float>()
    for (index in indices) {
        result.add(this[index] - x[index])
    }
    return result
}

/* Dot product of two vectors */
infix fun Vector.dot(x: Vector): Float {
    require(this.size == x.size) { "Vectors size must be equal" }
    var result = 0F
    for (index in indices) {
        result += this[index] * x[index]
    }
    return result
}

/* Cartesian cross product */
infix fun Vector.cross(x: Vector): Vector {
    require(this.size == x.size && size == 3) { "Vectors size must be equal and size should be 3" }
    val result = mutableListOf<Float>()
    val unitVectors = listOf<Int>(1, -1, 1) //this is i j k
    result.add(unitVectors[0] * (this[1] * x[2] - this[2] * x[1]))
    result.add(unitVectors[1] * (this[0] * x[2] - this[2] * x[0]))
    result.add(unitVectors[2] * (this[0] * x[1] - this[1] * x[0]))
    return result
}
