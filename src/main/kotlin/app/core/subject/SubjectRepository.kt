package app.core.subject

import app.core.Database
import app.core.polymorphism.GettableById
import app.core.polymorphism.Repository
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.sql.Connection

internal class SubjectRepository(private val connection: Connection) :
    Repository<Subject>(connection),
    GettableById<Subject> {
    private companion object SQLCommands {
        private const val all = "SELECT * FROM Subject"

        private const val getById = "SELECT * FROM Subject " +
                "WHERE id = ?"

        private const val getTitleById = "SELECT title FROM Subject " +
                "WHERE id = ?"

        private const val maxId = "SELECT MAX(id) as max_id FROM Subject"

        private const val add = "INSERT INTO Subject (id, title) " +
                "VALUES (?, ?)"

        private const val update = "UPDATE Subject SET " +
                "title = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Subject " +
                "WHERE id = ?"

        private const val getIdByTeachId = "SELECT subject_id FROM Teach_Subj " +
                "WHERE teacher_id = ?"

        private const val getIdByDepId = "SELECT subject_id FROM Subj_Dep " +
                "WHERE department_id = ?"
    }

    override fun getById(id: Int, mod: Int) = connection
        .prepareStatement(if (mod == 0) getIdByTeachId else getIdByDepId)
        .apply { setInt(1, id) }
        .use { stm ->
            stm.executeQuery().use { res ->
                when {
                    res.next() -> connection
                        .prepareStatement(getById)
                        .apply { setInt(1, res.getInt("subject_id")) }
                        .use { stm ->
                            stm.executeQuery().use { res ->
                                mutableListOf<Subject>().apply {
                                    while (res.next()) {
                                        add(
                                            Subject(
                                                res.getInt("id"),
                                                res.getString("title"),
                                            )
                                        )
                                    }
                                }.toTypedArray()
                            }
                        }

                    else -> arrayOf()
                }
            }
        }

    override fun all() = connection.createStatement().use { stm ->
        stm.executeQuery(all).use { res ->
            mutableListOf<Subject>().apply {
                while (res.next()) {
                    val id = res.getInt("id")

                    add(
                        Subject(
                            id,
                            res.getString("title"),
                            Database.teacherRepository.getById(id, 1),
                            Database.departmentRepository.getById(id)
                        )
                    )
                }
            }.toTypedArray()
        }
    }

    override fun update(vararg args: Either<String, Int>?) = action(update, *args)
    fun add(vararg args: Either<String, Int>?) = action(add, *args)
    fun remove(id: Int) = action(remove, Either.Right(id))
    fun nextId() = nextId(maxId)

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

    fun getById(id: Int) = connection
        .prepareStatement(getById)
        .apply { setInt(1, id) }
        .use { stm ->
            stm.executeQuery().use { res ->
                when {
                    res.next() -> Some(
                        Subject(
                            res.getInt("id"),
                            res.getString("title"),
                            arrayOf(),
                            arrayOf()
                        )
                    )

                    else -> None
                }
            }
        }
}