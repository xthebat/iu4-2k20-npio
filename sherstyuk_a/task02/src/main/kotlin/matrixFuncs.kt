package ru.bmstu.iu4.task02

import ru.bmstu.iu4.task02.vectorFuncs.dot
import ru.bmstu.iu4.task02.vectorFuncs.plus
import ru.bmstu.iu4.task02.vectorFuncs.minus
import ru.bmstu.iu4.task02.vectorFuncs.equals

typealias Mat = List<Vec>

object matrixFuncs {
    operator fun Mat.plus(other: Mat): Mat {
        require(this.count() == other.count()) {"Size of matrixes should be equal"}

        val resMat = mutableListOf<Vec>()
        var row: Vec
        for (i in indices) {
            row = this[i] + other[i]
            resMat.add(row)
        }
        return resMat
    }
    operator fun Mat.minus(other: Mat): Mat {
        require(this.count() == other.count()) {"Size of matrixes should be equal"}

        val resMat = mutableListOf<Vec>()
        var row: Vec
        for (i in indices) {
            row = this[i] - other[i]
            resMat.add(row)
        }
        return resMat
    }
    infix fun Mat.equals(other: Mat): Boolean {
        require(this.count() == other.count()) {"Size of matrixes should be equal"}

        for (i in indices) {
            if (!(this[i] equals other[i])) {
                return false
            }
        }
        return true
    }
    fun Mat.transpose(): Mat {
        val transMat = mutableListOf<Vec>()
        val row = mutableListOf<Double>()
        for (i in this[0].indices) {
            for (j in this.indices) {
                row.add(this[j][i])
            }
            transMat.add(row.toMutableList())
            row.clear()
        }
        return transMat
    }
    infix fun Mat.cross(other: Mat): Mat {
        require(this.count() == other.count()) {"Size of matrixes should be equal"}

        val resMat = mutableListOf<Vec>()
        val transMat = this.transpose()
        val row = mutableListOf<Double>()

        for (i in indices) {
            for (j in indices) {
                row.add(this[i] dot transMat[j])
            }
            resMat.add(row.toMutableList())
            row.clear()
        }
        return resMat
    }

    @JvmName("crossVec")
    infix fun Mat.cross(other: Vec): Mat {
        val resMat = mutableListOf<Vec>()
        val row = mutableListOf<Double>()

        for (i in indices) {
            row.add(this[i] dot other)
            resMat.add(row.toMutableList())
            row.clear()
        }
        return resMat
    }
}