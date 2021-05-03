package app.core.group

import app.core.Database
import app.core.polymorphism.*
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.sql.Connection

internal class GroupRepository(private val connection: Connection) :
    Repository(connection),
    GettableById<Group>,
    GettableIdByParams {
    private companion object SQLCommands {
        private const val all = "SELECT * FROM Groups"

        private const val maxId = "SELECT MAX(id) as max_id FROM Groups"

        private const val getTitleById = "SELECT title FROM Groups " +
                "WHERE id = ?"

        private const val getIdByTitle = "SELECT id FROM Groups " +
                "WHERE title = ?"

        private const val add = "INSERT INTO Groups (id, title, speciality_id) " +
                "VALUES (?, ?, ?)"

        private const val update = "UPDATE Groups SET " +
                "title = ?, speciality_id = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Groups " +
                "WHERE id = ?"

        private const val getBySpecId = "SELECT * FROM Groups " +
                "WHERE speciality_id = ?"
    }

    override fun getById(id: Int, mod: Int) = connection
        .prepareStatement(getBySpecId)
        .apply { setInt(1, id) }
        .use { stm ->
            stm.executeQuery().use { res ->
                mutableListOf<Group>().apply {
                    while (res.next()) {
                        add(
                            Group(
                                res.getInt("id"),
                                res.getString("title"),
                                res.getInt("speciality_id"),
                            )
                        )
                    }
                }.toTypedArray()
            }
        }

    override fun all() = connection.createStatement().use { stm ->
        stm.executeQuery(all).use { res ->
            mutableListOf<Entity>().apply {
                while (res.next()) {
                    val id = res.getInt("id")

                    add(
                        Group(
                            id,
                            res.getString("title"),
                            res.getInt("speciality_id"),
                            Database.studentRepository.getById(id)
                        )
                    )
                }
            }.toTypedArray()
        }
    }

    override fun update(vararg args: Either<String, Int>?) = action(update, *args)

    fun getTitleById(id: Int) = connection
        .prepareStatement(getTitleById)
        .apply { setInt(1, id) }
        .use { stm ->
            stm.executeQuery().use { res ->
                when {
                    res.next() -> Some(res.getString("title"))
                    else -> None
                }
            }
        }

    fun add(vararg args: Either<String, Int>?) = action(add, args[0], args[1], null)
    fun remove(id: Int) = action(remove, Either.Right(id))
    fun nextId() = nextId(maxId)
    fun getIdByTitle(title: String) = getIdByParams(getIdByTitle, connection, Either.Left(title))
}