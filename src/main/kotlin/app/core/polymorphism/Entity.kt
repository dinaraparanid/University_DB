package app.core.polymorphism

internal abstract class Entity {
    abstract fun id(): Int
    abstract fun asStringArray(): Array<String>
}