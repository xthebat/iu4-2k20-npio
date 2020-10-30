package ru.bmstu.iu4.fadeev

/**
 * Create vector
 */
fun vectorNew(input: String): Vector {
    val out: Vector = Vector()
    val count = input.split(",")

    for (i in count) out.add(i.toFloat())

    return out
}

/**
 * Multiplication V*V
 * Multiplication V*F
 * Increase V+V
 * Decrease V-V
 */
operator fun Vector.times(input: Vector): Vector {
    for (i in indices)
        this[i] *= input[i]
    return this
}

operator fun Vector.times(input: Float): Vector {
    for (i in indices)
        this[i] *= input
    return this
}

operator fun Vector.plus(input: Vector): Vector {
    for (i in indices)
        this[i] += input[i]
    return this
}

operator fun Vector.minus(input: Vector): Vector {
    for (i in indices)
        this[i] -= input[i]
    return this
}

/**
 * Vector cross Matrix
 */
fun Vector.vCrossMatrix(input: Matrix): Vector {
    require(size == input[0].size) { "vector size does not match matrix size" }
    var out: Vector = Vector()
    for (i in input[0].indices) {
        var line: Float = 0F
        for (j in input.indices)
            line += input[j][i] * this[i]
        out.add(line)
        println(out)
    }
    return out
}
