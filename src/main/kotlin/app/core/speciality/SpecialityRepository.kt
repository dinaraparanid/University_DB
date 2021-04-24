package app.core.speciality

import app.core.*
import arrow.core.Either
import java.sql.Connection

internal class SpecialityRepository(private val connection: Connection) : Repository<Speciality>(connection) {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Speciality"

        private const val filtered = "SELECT * FROM Speciality " +
                "WHERE id = ?"

        private const val maxId = "SELECT MAX(id) FROM Speciality"

        private const val add = "INSERT INTO Speciality (id, title) " +
                "VALUES (?, ?)"

        private const val update = "UPDATE Speciality SET " +
                "title = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Speciality " +
                "WHERE title = ?"

        private const val param = "SELECT speciality_id FROM Teach_Spec " +
                "WHERE teacher_id = ?"
    }

    override fun all(id: Int, mod: Int) = connection
        .prepareStatement(param)
        .apply { setInt(1, id) }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    res.next()

                    connection
                        .prepareStatement(filtered)
                        .apply { setInt(1, res.getInt("speciality_id")) }
                        .use { stm ->
                            stm
                                .executeQuery()
                                .use { res ->
                                    mutableListOf<Speciality>()
                                        .apply {
                                            while (res.next()) {
                                                add(
                                                    Speciality(
                                                        res.getInt("id"),
                                                        res.getString("title"),
                                                        arrayOf(),
                                                        arrayOf()
                                                    )
                                                )
                                            }
                                        }
                                        .toTypedArray()
                                }
                        }
                }

        }

    override fun all() = connection
        .createStatement()
        .use { stm ->
            stm
                .executeQuery(all)
                .use { res ->
                    mutableListOf<Speciality>()
                        .apply {
                            while (res.next()) {
                                val id = res.getInt("id")

                                add(
                                    Speciality(
                                        id,
                                        res.getString("title"),
                                        Database.groupRepository.all(id),
                                        Database.teacherRepository.all(id)
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