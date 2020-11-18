package ru.bmstu.iu4.korchagin.task03

fun setwL(str: String, width: Int): String {
    var builder = java.lang.StringBuilder()
    for (x in str.length until width) {
        print(' ')
        builder.append(" ")
    }
    print(str)
    builder.append(str)
    return builder.toString()
}


fun setwR(str: String, width: Int): String {
    var builder = java.lang.StringBuilder()
    print(str)
    builder.append(str)
    for (x in str.length until width) {
        print(' ')
        builder.append(" ")
    }
    return builder.toString()
}

fun getPriceToFloat(price: Float): String {
    var inputString = price.toString()

    val length = inputString.length
    var builder = StringBuilder()
    var startPoint = 0
    var stopPoint = 0
    var iteration: Int
    builder.append("$")
    if (((length - 3).rem(3) - 3) == 0) {
        iteration = (length - 3) / 3
    } else {
        iteration = (length - 3).div(3) + 1
    }
    for (i in 0 until iteration) {
        if (i == 0) {
            if ((length - 3).rem(3) != 0) {
                stopPoint = length.rem(3)
            } else {
                stopPoint = 2
            }
        } else {
            stopPoint += 3
        }
        builder.append(inputString.substring(startPoint, stopPoint))
        if (i != iteration - 1) {
            builder.append(",")
        }
        startPoint = stopPoint
    }
    builder.append(inputString.substring(length - 3, length))
    return builder.toString()
}