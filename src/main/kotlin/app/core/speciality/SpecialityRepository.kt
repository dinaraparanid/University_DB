package app.core.speciality

import app.core.Database
import app.core.polymorphism.*
import arrow.core.Either
import java.sql.Connection

internal class SpecialityRepository(private val connection: Connection) :
    Repository<Speciality>(connection),
    GettableById<Speciality>,
    GettableIdByParams {
    private companion object SQLCommands {
        private const val all = "SELECT * FROM Speciality"

        private const val getBydId = "SELECT * FROM Speciality " +
                "WHERE id = ?"

        private const val getTitleById = "SELECT title FROM Speciality " +
                "WHERE id = ?"

        private const val getIdByTitle = "SELECT id FROM Speciality " +
                "WHERE title = ?"

        private const val maxId = "SELECT MAX(id) as max_id FROM Speciality"

        private const val add = "INSERT INTO Speciality (id, title) " +
                "VALUES (?, ?)"

        private const val update = "UPDATE Speciality SET " +
                "title = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Speciality " +
                "WHERE id = ?"

        private const val getIdByTeachId = "SELECT speciality_id FROM Teach_Spec " +
                "WHERE teacher_id = ?"

        private const val maxIdTeachSpec = "SELECT MAX(id) as max_id FROM Teach_Spec"

        private const val addTeacher = "INSERT INTO Teach_Spec (id, teacher_id, speciality_id) " +
                "VALUES (?, ?, ?)"

        private const val removeTeacher = "DELETE FROM Teach_Spec " +
                "WHERE teacher_id = ? AND speciality_id = ?"
    }

    override fun getById(id: Int, mod: Int) = connection
        .prepareStatement(getIdByTeachId)
        .apply { setInt(1, id) }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    res.next()

                    connection
                        .prepareStatement(getBydId)
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
                                        Database.groupRepository.getById(id),
                                        Database.teacherRepository.getById(id)
                                    )
                                )
                            }
                        }
                        .toTypedArray()
                }
        }

    override fun update(vararg args: Either<String, Int>?) = action(update, *args)

    fun getTitleById(id: Int): String = connection
        .prepareStatement(getTitleById)
        .apply { setInt(1, id) }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    res.next()
                    res.getString("title")
                }
        }

    fun addTeacher(teacherId: Int, specialityId: Int) = action(
        addTeacher,
        Either.Right(nextIdTeachSpec()),
        Either.Right(teacherId),
        Either.Right(specialityId)
    )

    fun removeTeacher(teacherId: Int, specialityId: Int) = action(
        removeTeacher,
        Either.Right(teacherId),
        Either.Right(specialityId)
    )

    fun add(vararg args: Either<String, Int>?) = action(add, *args)
    fun remove(id: Int) = action(remove, Either.Right(id))
    fun nextId() = nextId(maxId)
    fun getIdByTitle(title: String) = getIdByParams(getIdByTitle, connection, Either.Left(title))
    private fun nextIdTeachSpec() = nextId(maxIdTeachSpec)
}