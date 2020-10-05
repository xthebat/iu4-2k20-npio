package ru.bmstu.iu4.sem05.common

import ru.bmstu.iu4.sem05.interfaces.Drawable

class Canvas(val width: Int, val height: Int, val resolution: Int) {
    /**
     * ***************************************************************************************************************
     * *                                                                                                             *
     * *                             *                                * <- Point                                     *
     * *                          *     *      <- Circle                                                             *
     * *                        *         *                 *                                                        *
     * *                          *     *                     *   <- Line                                            *
     * *                             *                          *                                                    *
     * *                                                                                                             *
     * ***************************************************************************************************************
     *
     */

    init {
        require(resolution >= 1)
    }

    private fun canvas(): Array<CharArray> {
        val canvasArray = Array(height*resolution) { CharArray(width*resolution) { ' ' } }
        for (i in 0 until height*resolution) {
            if (i < resolution || i > height*resolution-resolution) for (x in 0 until width*resolution)
                canvasArray[i][x] = '*'
            else {
                for (x in 0 until resolution) canvasArray[i][x] = '*'
                for (x in width*resolution-resolution until width*resolution) canvasArray[i][x] = '*'
            }
        }
        return canvasArray
    }

    fun draw(elements: Collection<Drawable>) = plot(canvas()).also { elements.forEach { e -> e.draw(it) } }
}