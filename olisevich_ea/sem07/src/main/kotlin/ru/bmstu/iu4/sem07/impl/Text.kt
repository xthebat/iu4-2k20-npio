package ru.bmstu.iu4.sem07.impl

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.interfaces.Printable

class Text(val data: String) : Entity() {
    override fun toString() = data.toString()

    internal val writer = Printable { writer ->
        writer.write("$data\n")
    }

    init {
        addComponent(writer)
    }

}