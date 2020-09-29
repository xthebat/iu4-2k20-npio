package ru.bmstu.iu4.task02

typealias Vector = List<Float>
operator fun Vector.plus(other: Vector): Vector {
    if (this.size != other.size) throw Exception("Vectors size must be equal")
    val result = mutableListOf<Float>()
    for (index in indices){
        result.add(this[index] + other[index])
    }
    return result
}

operator fun Vector.minus(other: Vector): Vector {
    if (this.size != other.size) throw  Exception("Vectors size must be equal")
    val result = mutableListOf<Float>()
    for (index in indices){
        result.add(this[index] - other[index])
    }
    return result
}

infix fun Vector.dot(other: Vector): Float{
    if (this.size != other.size) throw  Exception("Vectors size must be equal")
    var result = 0F
    for (index in indices){
        result += this[index]*other[index]
    }
    return result
}

infix fun Vector.cross(other: Vector): Vector {
    if (this.size != other.size && size != 3)
        throw  Exception("Vectors size must be equal and size should be 3")
    val result = mutableListOf<Float>()
    val item1 = this[1]*other[2]-this[2]*other[1]
    val item2 = -(this[0]*other[2]-this[2]*other[0])
    val item3 = this[0]*other[1]-this[1]*other[0]
    result.add(item1)
    result.add(item2)
    result.add(item3)
    return result
}