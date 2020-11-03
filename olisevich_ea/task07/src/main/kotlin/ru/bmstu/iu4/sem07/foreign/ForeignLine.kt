package ru.bmstu.iu4.sem07.foreign

class ForeignLine(val x0: Int, val y0: Int, val x1: Int, val y1: Int) {
    fun draw(): List<Pair<Int, Int>> {
        if (x0 == x1) {
            return List(y1 - y0) { x0 to it + y0 }
        } else {
            throw NotImplementedError()
        }
    }
}