package ru.bmstu.iu4.uzenkovD.task01.helloWorld

/**
 * Convert [array] of string into collections of ints
 *
 * NOTE: It isn't idiomatic Kotlin code (far from it) just for simple-simple example for basic syntax
 */
fun convertStrings2Ints(array: Array<String>): List<Int> {
    val result = mutableListOf<Int>()
    for (item in array) result.add(item.toInt())
    return result
}

/**
 * Get max value from [list]
 */
fun min(list: List<Int>): Int {
    // convenient argument verification function
    require(list.isNotEmpty()) { "Cant found min element in empty list!!!" }
    var result = Int.MAX_VALUE
    for (item in list) {
        if (item < result)
            result = item
    }
    return result
}

/**
 * Get max value from [list]
 */
fun max(list: List<Int>): Int {
    require(list.isNotEmpty()) { "Cant found max element in empty list!!!" }
    var result = Int.MIN_VALUE
    for (item in list) {
        if (item > result)
            result = item
    }
    return result
}

/**
 * fizzbuzz round
 */
fun fizzbuzz(value: Int) = when {
    value % 3 == 0 && value % 5 == 0 -> "FizzBuzz"
    value % 3 == 0 -> "Fizz"
    value % 5 == 0 -> "Buzz"
    else -> value.toString()
}

/**
 * Count number of character [char] in [string]
 */
fun count(string: String, char: Char): Int {
    var result = 0
    for (item in string) {
        if (item == char)
            result++
    }
    return result
}

/**
 * Play a fizzbuzz game starting from [start] value until [threshold] reached
 * and use as lookup character [char] ('u' by default)
 *
 * NOTE: this is not actually fizzbuzz game (just an example for a while-loop)
 */
fun play(start: Int, threshold: Int, char: Char = 'u'): Int {
    var count = 0
    var round = start
    while (count < threshold) {
        val value = fizzbuzz(round++)
        count += count(value, char)
    }
    return round - 1
}
