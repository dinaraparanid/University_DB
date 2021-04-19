package app

import java.io.Serializable

internal interface Repository<T> {
    fun all(): Array<T>
    fun all(id: Int, mod: Int = 0): Array<T>
    fun add(vararg args: Serializable)
    fun update(vararg args: Serializable)
    fun remove(vararg args: Serializable)
}