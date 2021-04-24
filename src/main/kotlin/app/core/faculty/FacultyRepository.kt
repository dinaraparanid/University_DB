package app.core.faculty

import app.core.*
import app.setValOrNull
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.sql.Connection

internal class FacultyRepository(private val connection: Connection) : Repository<Faculty> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Faculty"

        private const val maxId = "SELECT MAX(id) FROM Faculty"

        private const val add = "INSERT INTO Faculty (id, title) " +
                "VALUES (?, ?)"

        private const val update = "UPDATE Faculty SET " +
                "title = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Faculty " +
                "WHERE title = ?"
    }

    override fun all(id: Int, mod: Int) = arrayOf<Faculty>()

    override fun all() = connection
        .createStatement()
        .use { stm ->
            stm
                .executeQuery(all)
                .use { res ->
                    mutableListOf<Faculty>()
                        .apply {
                            while (res.next()) {
                                val id = res.getInt("id")

                                add(
                                    Faculty(
                                        id,
                                        res.getString("title"),
                                        Database.departmentRepository.all(id)
                                    )
                                )
                            }
                        }
                        .toTypedArray()
                }
        }

    override fun add(vararg args: Either<String, Int>) = connection
        .prepareStatement(add)
        .apply {
            setValOrNull(1, args[0]) // id
            setValOrNull(2, args[1]) // title
        }
        .use { stm ->
            try {
                stm.execute()
                Some(Unit)
            } catch (e: Exception) {
                None
            }
        }

    override fun update(vararg args: Either<String, Int>) = connection
        .prepareStatement(update)
        .apply {
            setValOrNull(1, args[0]) // title
            setValOrNull(2, args[1]) // id
        }
        .use { stm ->
            try {
                stm.execute()
                Some(Unit)
            } catch (e: Exception) {
                None
            }
        }

    override fun remove(vararg args: Either<String, Int>) = connection
        .prepareStatement(remove)
        .apply { setValOrNull(1, args[0]) } // title
        .use { stm ->
            try {
                stm.execute()
                Some(Unit)
            } catch (e: Exception) {
                None
            }
        }

    override fun nextId() = connection
        .createStatement()
        .use { stm ->
            stm
                .executeQuery(maxId)
                .use { res ->
                    res.next()
                    res.getInt("id")
                }
        }
}