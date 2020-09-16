package ru.bmstu.iu4.task02

import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger

typealias Vec = List<Double>

object vectorFuncs {
    val log = logger(FINEST)

    operator fun Vec.plus(other: Vec): Vec{
        require(this.count() == other.count()) {"Size of vectors should be equal"}

        val resVec = mutableListOf<Double>()
        for (i in indices) {
            resVec.add(this[i] + other[i])
        }

        return resVec
    }
    operator fun Vec.minus(other: Vec): Vec{
        require(this.count() == other.count()) {"Size of vectors should be equal"}

        val resVec = mutableListOf<Double>()
        for (i in indices) {
            resVec.add(this[i] - other[i])
        }

        return resVec
    }
    infix fun Vec.equals(other: Vec): Boolean {
        require(this.count() == other.count()) {"Size of vectors should be equal"}

        for (i in indices) {
            if (this[i] != other[i]) {
                return false
            }
        }

        return true
    }
    infix fun Vec.dot(other: Vec): Double {
        require(this.count() == other.count()) {"Size of vectors should be equal"}

        var res = 0.0
        for (i in indices) {
            res += this[i] * other[i]
        }

        return res
    }
    infix fun Vec.cross(other: Vec): Vec {
        require(this.count() == other.count()) {"Size of vectors should be equal"}
        require(this.count() == 3) {"Size of vector should be 3"}

        val resVec = mutableListOf<Double>()

        val item1 = this[1]*other[2]-this[2]*other[1]
        val item2 = -(this[0]*other[2]-this[2]*other[0])
        val item3 = this[0]*other[1]-this[1]*other[0]
        resVec.add(item1)
        resVec.add(item2)
        resVec.add(item3)

        return resVec
    }
}