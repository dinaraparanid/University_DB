package app.core.polymorphism

internal interface Entity {
    fun id(): Int
    fun asStringArray(): Array<String>
}