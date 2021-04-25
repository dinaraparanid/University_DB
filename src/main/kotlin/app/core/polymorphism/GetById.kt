package app.core.polymorphism

internal interface GetById<T> {
    fun getById(id: Int, mod: Int = 0): Array<T>
}