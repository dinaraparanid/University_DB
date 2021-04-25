package app.core.polymorphism

import arrow.core.None
import arrow.core.Some
import java.sql.Connection

internal interface GetIdByTitle

internal fun GetIdByTitle.getIdByTitle(filteredTitle: String, title: String, connection: Connection) =
    connection
        .prepareStatement(filteredTitle)
        .apply { setString(1, title) }
        .use { stm ->
            stm
                .executeQuery(filteredTitle)
                .use { res ->
                    res.next()

                    try {
                        Some(res.getInt("id"))
                    } catch (e: Exception) {
                        None
                    }
                }
        }