package ru.bmstu.iu4.sem02

fun squareOutOfPlace(list: List<Int>): List<Int> {
    val output = mutableListOf<Int>()
    for (k in list.indices) {
        output.add(list[k] * list[k])
    }
    return output
}

fun squareInPlace(list: MutableList<Int>) {
    for (k in list.indices) {
        list[k] *= list[k]
    }
}

fun List<Int>.square(): List<Int> {
    val output = mutableListOf<Int>()
    for (k in this.indices) {
        output.add(this[k] * this[k])
    }
    return output
}

fun List<Int>.toStringList(): List<String> {
    val output = mutableListOf<String>()
    for (k in this.indices) {
        output.add(this[k].toString())
    }
    return output
}

fun List<Int>.toLongList(): List<Long> {
    val output = mutableListOf<Long>()
    for (k in this.indices) {
        output.add(this[k].toLong())
    }
    return output
}

fun List<String>.parseInt(radix: Int = 10): List<Int> {
    val output = mutableListOf<Int>()
    for (k in this.indices) {
        output.add(this[k].toInt(radix))
    }
    return output
}

infix fun <T> List<T>.concat(other: List<T>): List<T> {
    val output = mutableListOf<T>()

    for (item in this) {
        output.add(item)
    }

    for (item in other) {
        output.add(item)
    }

    return output
}
