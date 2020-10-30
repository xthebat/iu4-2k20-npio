package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.common.Plot
import ru.bmstu.iu4.sem05.interfaces.Drawable

class Line(val src: Point, val dst: Point) : Drawable {

    override fun draw(plot: Plot) {
        if (src.x.toInt() == dst.x.toInt() && src.y.toInt() < dst.y.toInt())
            for (i in src.y.toInt() until dst.y.toInt()) plot[src.x.toInt()][i] = '*'

        if (src.x.toInt() == dst.x.toInt() && src.y.toInt() > dst.y.toInt())
            for (i in dst.y.toInt() until src.y.toInt()) plot[src.x.toInt()][i] = '*'

        if (src.y.toInt() == dst.y.toInt() && src.x.toInt() < dst.x.toInt())
            for (i in src.x.toInt() until dst.x.toInt()) plot[i][src.y.toInt()] = '*'

        if (src.x.toInt() > dst.x.toInt() && src.y.toInt() == dst.y.toInt())
            for (i in dst.x.toInt() until src.x.toInt()) plot[i][src.y.toInt()] = '*'

        if (src.x.toInt() == dst.x.toInt() && src.y.toInt() == dst.y.toInt())
            plot[src.x.toInt()][src.y.toInt()] = '*'

        if (src.x.toInt() < dst.x.toInt() && src.y.toInt() < dst.y.toInt()) {
            val xDistance = dst.x.toInt() - src.x.toInt()
            val yDistance = dst.y.toInt() - src.y.toInt()
            if (xDistance == yDistance) for (i in src.x.toInt()..dst.x.toInt()) plot[i][src.y.toInt()
                    + i - src.x.toInt()] = '*'
            if (xDistance > yDistance) {
                val step: Double = yDistance.toDouble()/xDistance.toDouble()
                var tempY: Double = src.y
                for (i in  src.x.toInt()..dst.x.toInt()) {plot[i][tempY.toInt()] = '*'; tempY += step}
            }
            if (xDistance < yDistance) {
                val step: Double = xDistance.toDouble()/yDistance.toDouble()
                var tempX: Double = src.x
                for (i in  src.y.toInt()..dst.y.toInt()) {plot[tempX.toInt()][i] = '*'; tempX += step}
            }
        }

        if (src.x.toInt() > dst.x.toInt() && src.y.toInt() < dst.y.toInt()) {
            val xDistance = src.x.toInt() - dst.x.toInt()
            val yDistance = dst.y.toInt() - src.y.toInt()
            if (xDistance == yDistance) for (i in dst.x.toInt()..src.x.toInt()) plot[i][dst.y.toInt()
                    + dst.x.toInt() - i] = '*'
            if (xDistance > yDistance) {
                val step: Double = yDistance.toDouble()/xDistance.toDouble()
                var tempY: Double = dst.y
                for (i in  dst.x.toInt()..src.x.toInt()) {plot[i][tempY.toInt()] = '*'; tempY -= step}
            }
            if (xDistance < yDistance) {
                val step: Double = xDistance.toDouble()/yDistance.toDouble()
                var tempX: Double = src.x
                for (i in  src.y.toInt()..dst.y.toInt()) {plot[tempX.toInt()][i] = '*'; tempX -= step}
            }
        }

        if (src.x.toInt() < dst.x.toInt() && src.y.toInt() > dst.y.toInt()) {
            val xDistance = dst.x.toInt() - src.x.toInt()
            val yDistance = src.y.toInt() - dst.y.toInt()
            if (xDistance == yDistance) for (i in src.x.toInt()..dst.x.toInt()) plot[i][src.y.toInt()
                    + src.x.toInt() - i] = '*'
            if (xDistance > yDistance) {
                val step: Double = yDistance.toDouble()/xDistance.toDouble()
                var tempY: Double = src.y
                for (i in  src.x.toInt()..dst.x.toInt()) {plot[i][tempY.toInt()] = '*'; tempY -= step}
            }
            if (xDistance < yDistance) {
                val step: Double = xDistance.toDouble()/yDistance.toDouble()
                var tempX: Double = dst.x
                for (i in  dst.y.toInt()..src.y.toInt()) {plot[tempX.toInt()][i] = '*'; tempX -= step}
            }
        }

        if (src.x.toInt() > dst.x.toInt() && src.y.toInt() > dst.y.toInt()) {
            val xDistance = src.x.toInt() - dst.x.toInt()
            val yDistance = src.y.toInt() - dst.y.toInt()
            if (xDistance == yDistance) for (i in dst.x.toInt()..src.x.toInt()) plot[i][dst.y.toInt()
                    + i - dst.x.toInt()] = '*'
            if (xDistance > yDistance) {
                val step: Double = yDistance.toDouble()/xDistance.toDouble()
                var tempY: Double = dst.y
                for (i in  dst.x.toInt()..src.x.toInt()) {plot[i][tempY.toInt()] = '*'; tempY += step}
            }
            if (xDistance < yDistance) {
                val step: Double = xDistance.toDouble()/yDistance.toDouble()
                var tempX: Double = dst.x
                for (i in  dst.y.toInt()..src.y.toInt()) {plot[tempX.toInt()][i] = '*'; tempX += step}
            }
        }
    }
}