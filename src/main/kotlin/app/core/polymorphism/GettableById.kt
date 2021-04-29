package app.core.polymorphism

internal interface GettableById<T> {
    fun getById(id: Int, mod: Int = 0): Array<T>
}