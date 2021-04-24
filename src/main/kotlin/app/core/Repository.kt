package app.core

import arrow.core.Either
import arrow.core.Option

internal interface Repository<T> {
    fun nextId(): Int
    fun all(): Array<T>
    fun all(id: Int, mod: Int = 0): Array<T>
    fun add(vararg args: Either<String, Int>): Option<Unit>
    fun update(vararg args: Either<String, Int>): Option<Unit>
    fun remove(vararg args: Either<String, Int>): Option<Unit>
}