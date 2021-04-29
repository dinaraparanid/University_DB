package app.core.faculty

import app.core.Database
import app.core.polymorphism.*
import arrow.core.Either
import java.sql.Connection

internal class FacultyRepository(private val connection: Connection) :
    Repository(connection),
    GettableIdByParams {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Faculty"

        private const val filteredTitle = "SELECT id FROM Faculty " +
                "WHERE title = ?"

        private const val maxId = "SELECT MAX(id) as max_id FROM Faculty"

        private const val add = "INSERT INTO Faculty (id, title) " +
                "VALUES (?, ?)"

        private const val update = "UPDATE Faculty SET " +
                "title = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Faculty " +
                "WHERE id = ?"
    }

    override fun all() = connection
        .createStatement()
        .use { stm ->
            stm
                .executeQuery(all)
                .use { res ->
                    mutableListOf<StringContent>()
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

    override fun update(vararg args: Either<String, Int>?) = action(update, *args)
    fun add(vararg args: Either<String, Int>?) = action(add, *args)
    fun remove(id: Int) = action(remove, Either.Right(id))
    fun nextId() = nextId(maxId)
    fun getIdByTitle(title: String) = getIdByParams(filteredTitle, connection, Either.Left(title))
}