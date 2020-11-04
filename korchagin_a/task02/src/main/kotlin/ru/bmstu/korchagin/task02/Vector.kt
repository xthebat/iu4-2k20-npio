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
typealias Vector = List<Float>
typealias Matrix = List<List<Float>>

operator fun Vector.plus(vector: Vector): Vector{
    val output = mutableListOf<Float>();
    if (this.size == vector.size){
        for(i in 0 until this.size) {
            print(i)
            output.add(this[i] + vector[i])
        }
        return output;
    }
    return listOf(0F)
}

operator fun Vector.minus(vector: Vector): Vector{
    val output = mutableListOf<Float>()
    if (this.size == vector.size){
        for(i in 0 until this.size) {
            print(i)
            output.add(this[i] - vector[i])
        }
        return output;
    }
    return listOf(0F)
}

operator fun Vector.times(vector: Vector): Float{
    var output = 0F
    if (this.size == vector.size){
        for (i in 0 until this.size){
            output += this[i] * vector[i]
        }
    }
    return output
}

infix fun Vector.equals(vector: Vector): Boolean{
    if (this.size == vector.size){
        for(i in 0 until this.size) {
            if (this[i] != vector[i]){
                return false
            }
        }
        return true
    }
    return false
}

fun Vector.transponseToMatrix(): Matrix{
    var output = mutableListOf<List<Float>>()
    for (i in 0 until this.size){
        output.add(listOf(this[i]))
    }
    return output
}

fun Matrix.transponseToVector(): Vector{
    var output = mutableListOf<Float>()
    for (i in 0 until this.size){
        output.add(this[i].get(0))
    }
    return output
}

infix fun Vector.cross(vector: Vector): Vector{
    var output = mutableListOf<Float>()
    for (i in 0 until this.size){
        when(i){
            0 -> output.add(this[1] * vector[2] - this[2] * vector[1])
            1 -> output.add(this[0] * vector[2] - this[2] * vector[0])
            2 -> output.add(this[0] * vector[1] - this[1] * vector[0])
        }
    }

    return output
}