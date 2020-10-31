package ru.bmstu.iu4.sem07.interfaces

import java.io.Writer

// http://gameprogrammingpatterns.com/component.html
fun interface Printable : Component {
    fun print(writer: Writer)
}