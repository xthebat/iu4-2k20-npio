package ru.bmstu.iu4.task02

import ru.bmstu.iu4.task02.vectorFuncs.dot
import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger
import ru.bmstu.iu4.task02.vectorFuncs.plus
import ru.bmstu.iu4.task02.vectorFuncs.minus
import ru.bmstu.iu4.task02.vectorFuncs.equals
import kotlin.system.exitProcess

typealias Mat = List<Vec>

object matrixFuncs {
    val log = logger(FINEST)

    infix fun Mat.plus(other: Mat): Mat{

        matCheckSize(this, other)
        val resMat = mutableListOf<Vec>()
        var row: Vec
        for (i in indices) {
            row = this[i] plus other[i]
            resMat.add(row)
        }
        return resMat
    }

    infix fun Mat.minus(other: Mat): Mat{

        matCheckSize(this, other)
        val resMat = mutableListOf<Vec>()
        var row: Vec
        for (i in indices) {
            row = this[i] minus other[i]
            resMat.add(row)
        }
        return resMat
    }

    infix fun Mat.equals(other: Mat): Boolean {
        matCheckSize(this, other)
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
                print(row)
            }
            transMat.add(row.toMutableList())
            row.clear()
        }
        return transMat
    }

    infix fun Mat.cross(other: Mat): Mat {
        matCheckSize(this, other)

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

    infix fun Mat.crossVec(other: Vec): Mat {
        val resMat = mutableListOf<Vec>()
        val row = mutableListOf<Double>()

        for (i in indices) {
            row.add(this[i] dot other)
            resMat.add(row.toMutableList())
            row.clear()
        }
        return resMat
    }

    fun matCheckSize(mat1: Mat, mat2: Mat) {
        val mat1RowsCount = mat1.count()
        val mat2RowsCount = mat2.count()

        if (mat1RowsCount != mat2RowsCount) {
            log.warning { "Different size of rows" }
            exitProcess(-1)
        }
    }
}