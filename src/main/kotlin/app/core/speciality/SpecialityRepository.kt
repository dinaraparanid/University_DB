package app.core.speciality

import app.core.*
import app.setValOrNull
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.sql.Connection

internal class SpecialityRepository(private val connection: Connection) : Repository<Speciality> {
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