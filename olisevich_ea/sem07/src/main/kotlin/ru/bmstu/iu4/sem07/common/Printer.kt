package ru.bmstu.iu4.sem07.common

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.interfaces.Printable
import ru.inforion.lab403.common.logging.logger
import java.io.Writer


// TODO: Add some printable classes
// http://gameprogrammingpatterns.com/component.html
class Printer(private val writer: Writer) {
    companion object {
        val log = logger()
    }

    fun print(elements: Collection<Entity>) = elements
            .forEach { element ->
                element[Printable::class]
                        ?.runCatching { print(writer) }
                        ?.onFailure { error -> log.severe { "Can't draw ${element::class.simpleName} [$element] -> $error" } }
                writer.flush()
            }
}