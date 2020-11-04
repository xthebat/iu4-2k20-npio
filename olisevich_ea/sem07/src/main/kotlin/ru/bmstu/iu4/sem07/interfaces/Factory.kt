package ru.bmstu.iu4.sem07.interfaces

import ru.bmstu.iu4.sem07.abstracts.Entity

interface Factory<T : Entity> {
    fun generate(): T
}