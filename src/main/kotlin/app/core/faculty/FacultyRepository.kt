package app.core.faculty

import app.core.Database
import app.core.polymorphism.Repository
import arrow.core.Either
import java.sql.Connection

internal class FacultyRepository(private val connection: Connection) : Repository<Faculty>(connection) {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Faculty"

        private const val maxId = "SELECT MAX(id) as max_id FROM Faculty"

        private const val add = "INSERT INTO Faculty (id, title) " +
                "VALUES (?, ?)"

        private const val update = "UPDATE Faculty SET " +
                "title = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Faculty " +
                "WHERE title = ?"
    }

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
                                        Database.departmentRepository.getById(id)
                                    )
                                )
                            }
                        }
                        .toTypedArray()
                }
        }

    fun add(vararg args: Either<String, Int>?) = action(add, *args)
    fun remove(vararg args: Either<String, Int>) = action(remove, *args)
    fun update(vararg args: Either<String, Int>) = action(update, *args)
    fun nextId() = nextId(maxId)
}