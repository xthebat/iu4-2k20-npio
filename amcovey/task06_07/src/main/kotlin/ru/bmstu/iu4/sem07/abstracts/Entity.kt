package ru.bmstu.iu4.sem07.abstracts

import ru.bmstu.iu4.sem07.interfaces.Component
import ru.bmstu.iu4.sem07.interfaces.Drawable
import kotlin.reflect.KClass

// http://gameprogrammingpatterns.com/component.html
open class Entity() {
    constructor(initializer: Entity.() -> Unit) : this() {
        initializer()
    }

    private val components = mutableMapOf<KClass<out Component>, Component>()

    // made possible to hide components
    fun <T: Component> addComponentByClass(component: Component, type: KClass<out T>) {
        val alreadyContains = components.values.any { type.isInstance(it) }
        require(!alreadyContains) { "Component with class '${type.simpleName}' or it superclass already in this Entity!" }
        components[type] = component
    }

    inline fun <reified T: Component> addComponent(component: T) = addComponentByClass(component, T::class)

    @Suppress("UNCHECKED_CAST")
    operator fun <T: Component> get(type: KClass<out T>) = components[type] as? T
}