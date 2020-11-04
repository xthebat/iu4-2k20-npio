package ru.bmstu.iu4.sem07.adaptors

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.common.Plot
import ru.bmstu.iu4.sem07.common.draw
import ru.bmstu.iu4.sem07.foreign.ForeignLine
import ru.bmstu.iu4.sem07.interfaces.Drawable

// TODO: delete
// https://en.wikipedia.org/wiki/Adapter_pattern
// https://www.dofactory.com/net/adapter-design-pattern
//class LineAdaptor(val line: ForeignLine) : Entity() {
//    override fun draw(plot: Plot) = line.draw().forEach { (x, y) -> plot.draw(x, y, '*') }
//}