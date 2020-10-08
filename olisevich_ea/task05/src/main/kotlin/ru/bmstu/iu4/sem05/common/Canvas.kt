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
    fun draw(elements: Collection<Drawable>) =
        plot(height * resolution, width * resolution).also { elements.forEach { e -> e.draw(it, resolution) } }
}