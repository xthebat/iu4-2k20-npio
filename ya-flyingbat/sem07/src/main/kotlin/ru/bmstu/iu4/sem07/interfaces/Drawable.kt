package ru.bmstu.iu4.sem07.interfaces

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.common.Plot

// http://gameprogrammingpatterns.com/component.html
fun interface Drawable : Component {
    companion object {
        /**
         * extension for Entity to simplify Entity definition
         */
        // https://en.wikipedia.org/wiki/Factory_method_pattern
        fun Entity.drawable(action: (Plot) -> Unit) = addComponent(Drawable(action))
    }

    fun draw(plot: Plot)
}