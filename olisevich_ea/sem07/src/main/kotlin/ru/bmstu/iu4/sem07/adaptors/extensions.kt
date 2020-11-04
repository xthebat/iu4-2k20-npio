package ru.bmstu.iu4.sem07.adaptors

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.common.draw
import ru.bmstu.iu4.sem07.foreign.ForeignLine
import ru.bmstu.iu4.sem07.interfaces.Drawable.Companion.drawable

// Adapter is now embedded in toSmth() function
// https://en.wikipedia.org/wiki/Adapter_pattern
// https://www.dofactory.com/net/adapter-design-pattern
fun ForeignLine.toDrawable() = Entity {
    drawable { plot -> draw().forEach { (x, y) -> plot.draw(x, y, '*') } }
}