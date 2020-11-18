package ru.bmstu.iu4.sem07.interfaces

import ru.bmstu.iu4.sem07.abstracts.Entity

// https://en.wikipedia.org/wiki/Builder_pattern
interface EntityBuilder {
    fun build(): Entity
}