package ru.bmstu.iu4.sem07.common

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.impl.Rectangle
import ru.bmstu.iu4.sem07.interfaces.Drawable
import ru.inforion.lab403.common.logging.logger

// http://gameprogrammingpatterns.com/component.html
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
    fun draw(elements: Collection<Entity>) = plot(width * resolution, height * resolution)
        .also {
//          TODO()  Rectangle(0, 0, width - 1, height - 1).draw(it)
            elements
                .forEach { element ->
                    element[Drawable::class]
                        ?.runCatching { draw(it) }
                        ?.onFailure { error -> log.severe { "Can't draw ${element::class.simpleName} [$element] -> $error" } }
                }
        }
}