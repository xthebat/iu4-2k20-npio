package ru.bmstu.iu4.task02

import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger
import kotlin.system.exitProcess

typealias Vec = List<Double>

object vectorFuncs {
    val log = logger(FINEST)

    infix fun Vec.plus(other: Vec): Vec{
        vecCheck(this, other)

        val resVec = mutableListOf<Double>()
        for (i in indices) {
            resVec.add(this[i] + other[i])
        }
        return resVec
    }
    infix fun Vec.minus(other: Vec): Vec{

        vecCheck(this, other)

        val resVec = mutableListOf<Double>()

        for (i in indices) {
            resVec.add(this[i] - other[i])
        }
        return resVec
    }
    infix fun Vec.equals(other: Vec): Boolean {
        vecCheck(this, other)
        for (i in indices) {
            if (this[i] != other[i]) {
                return false
            }
        }
        return true
    }
    infix fun Vec.dot(other: Vec): Double {
        vecCheck(this, other)

        var res = 0.0
        for (i in indices) {
            res += this[i] * other[i]
        }
        return res
    }
    private fun vecCheck(vec1: Vec, vec2: Vec) {
        val vec1Size = vec1.count()
        val vec2Size = vec2.count()

        if (vec1Size != vec2Size) {
            log.warning { "Different size of vectors" }
            exitProcess(-1)
        }
    }

    /*   infix fun Vec.cross(other: Vec) {


       }*/
}