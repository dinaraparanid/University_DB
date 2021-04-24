package app.core.group

import app.core.*
import arrow.core.Either
import java.sql.Connection

internal class GroupRepository(private val connection: Connection) : Repository<Group>(connection) {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Groups"

        private const val maxId = "SELECT MAX(id) FROM Groups"

        private const val add = "INSERT INTO Groups (id, title, speciality_id) " +
                "VALUES (?, ?, ?)"

        private const val update = "UPDATE Groups SET " +
                "title = ?, speciality_id = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Groups " +
                "WHERE title = ? AND speciality_id = ?"

        private const val param = "SELECT * FROM Groups " +
                "WHERE speciality_id = ?"
    }

    override fun all(id: Int, mod: Int) = connection
        .prepareStatement(param)
        .apply { setInt(1, id) }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    mutableListOf<Group>()
                        .apply {
                            while (res.next()) {
                                add(
                                    Group(
                                        res.getInt("id"),
                                        res.getString("title"),
                                        res.getInt("speciality_id"),
                                        arrayOf()
                                    )
                                )
                            }
                        }
                        .toTypedArray()
                }

        }

    override fun all() = connection
        .createStatement()
        .use { stm ->
            stm
                .executeQuery(all)
                .use { res ->
                    mutableListOf<Group>()
                        .apply {
                            while (res.next()) {
                                val id = res.getInt("id")

                                add(
                                    Group(
                                        id,
                                        res.getString("title"),
                                        res.getInt("speciality_id"),
                                        Database.studentRepository.all(id)
                                    )
                                )
                            }
                        }
                        .toTypedArray()
                }
        }

    fun add(vararg args: Either<String, Int>) = action(add, args[0], args[1], null)
    fun remove(vararg args: Either<String, Int>) = action(remove, *args)
    fun update(vararg args: Either<String, Int>) = action(update, *args)
    fun nextId() = nextId(maxId)
}