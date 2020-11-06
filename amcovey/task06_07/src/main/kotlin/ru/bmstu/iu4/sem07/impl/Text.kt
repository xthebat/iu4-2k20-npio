package ru.bmstu.iu4.sem07.impl

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.interfaces.Printable


// http://gameprogrammingpatterns.com/component.html
// TODO: implement
class Text(val text: String) : Entity() {

    internal val writer = Printable { writer -> writer.write("Text: $text")}

    init {
        addComponent(writer)
    }
}