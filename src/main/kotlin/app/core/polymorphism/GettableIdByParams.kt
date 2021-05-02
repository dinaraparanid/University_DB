package app.core.polymorphism

import app.setValOrNull
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.sql.Connection

internal interface GettableIdByParams

internal fun GettableIdByParams.getIdByParams(
    filteredTitle: String,
    connection: Connection,
    vararg params: Either<String, Int>?
) = connection
    .prepareStatement(filteredTitle)
    .apply { params.forEachIndexed { ind, p -> setValOrNull(ind, p) } }
    .use { stm ->
        stm.executeQuery().use { res ->
            when {
                res.next() -> Some(res.getInt("id"))
                else -> None
            }
        }
    }