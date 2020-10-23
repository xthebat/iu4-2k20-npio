package ru.bmstu.iu4.sem05.common

import ru.bmstu.iu4.sem05.impl.Rectangle
import ru.bmstu.iu4.sem05.interfaces.Drawable
import ru.inforion.lab403.common.logging.logger

class Canvas(val width: Int, val height: Int, val resolution: Int) {
    companion object {
        val log = logger()
    }

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
    fun draw(elements: Collection<Drawable>) = plot(width * resolution, height * resolution)
            .also {
                Rectangle(0, 0, width - 1, height - 1).draw(it)
                elements.forEach {
                    element -> element
                        .runCatching { draw(it) }
                        .onFailure { error -> log.severe { "Can't draw [$element] -> $error" } }
                }
            }
}