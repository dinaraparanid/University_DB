package app.core

import app.setValOrNull
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.sql.Connection

internal abstract class Repository<T>(private val connection: Connection) {
    abstract fun all(): Array<T>
    abstract fun all(id: Int, mod: Int = 0): Array<T>

    fun nextId(maxId: String) = connection
        .createStatement()
        .use { stm ->
            stm
                .executeQuery(maxId)
                .use { res ->
                    res.next()
                    res.getInt("id")
                }
        }

    fun action(statement: String, vararg setters: Either<String, Int>?) = connection
        .prepareStatement(statement)
        .apply { setters.forEachIndexed { ind, x -> setValOrNull(ind + 1, x) } }
        .use { stm ->
            try {
                stm.execute()
                Some(Unit)
            } catch (e: Exception) {
                None
            }
        }
}