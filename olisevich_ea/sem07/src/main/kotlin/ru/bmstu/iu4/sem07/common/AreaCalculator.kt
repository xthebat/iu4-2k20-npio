package ru.bmstu.iu4.sem07.common

import ru.bmstu.iu4.sem07.abstracts.Entity
import ru.bmstu.iu4.sem07.interfaces.AreaCalculateable
import ru.inforion.lab403.common.logging.logger

class AreaCalculator() {
    companion object {
        val log = logger()
    }

    fun calculate(elements: Collection<Entity>): Map<String, Int> {
        var res = mutableMapOf<String, Int>()
        elements.forEach { el ->
            el[AreaCalculateable::class]
                    ?.runCatching { res[el.toString()] = areaCalculate() }
                    ?.onFailure { error -> Canvas.log.severe { "Can't draw ${el::class.simpleName} [$el] -> $error" } }
        }

        return res
    }

}