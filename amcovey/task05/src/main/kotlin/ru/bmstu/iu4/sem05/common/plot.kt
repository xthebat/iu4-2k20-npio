package ru.bmstu.iu4.sem05.common

import ru.bmstu.iu4.sem05.impl.Line
import ru.bmstu.iu4.sem05.impl.Point
import java.io.Writer

typealias Plot = Array<CharArray>

fun plot(width: Int, height: Int, init: Char = ' '): Plot{
    val plot = Array(width) { CharArray(height) { init } }
    val frame = listOf(
        Line(Point(0, 0), Point(0, width - 1)),
        Line(Point(0, 0), Point(height - 1, 0)),
        Line(Point(height - 1, 0), Point(height - 1, width - 1)),
        Line(Point(0, width - 1), Point(height - 1, width - 1))
    )
    frame.forEach { it.draw(plot) }
    return plot
}

fun Plot.write(writer: Writer) = forEach {
    writer.write(it)
    writer.appendLine()
}

fun Plot.printPlot() {
    for (i in indices) {
        for (j in this[i].indices) {
            print(this[i][j])
            if (j != this[i].size - 1) print(" ")
        }
        if (i != size - 1) println()
    }
}