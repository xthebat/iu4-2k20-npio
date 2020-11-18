package ru.bmstu.iu4.sem07.abstracts

// TODO: delete and add AreaCalculator component
abstract class AbstractFigure(var tag: Int) : Entity() {
    open fun stringify() = "Figure(tag=$tag)"

    abstract fun area(): Int
}