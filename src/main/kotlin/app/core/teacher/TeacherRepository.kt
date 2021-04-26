package app.core.teacher

import app.core.Database
import app.core.polymorphism.GetById
import app.core.polymorphism.Repository
import arrow.core.Either
import java.sql.Connection

internal class TeacherRepository(private val connection: Connection) :
    Repository<Teacher>(connection),
    GetById<Teacher> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Teacher"

        private const val filtered = "SELECT * FROM Teacher " +
                "WHERE id = ?"

        private const val maxId = "SELECT MAX(id) as max_id FROM Teacher"

        private const val add = "INSERT INTO Teacher (id, f_name, s_name, m_name, info) " +
                "VALUES (?, ?, ?, ?, ?)"

        private const val update = "UPDATE Teacher SET " +
                "f_name = ?, s_name = ?, m_name = ?, info = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Teacher " +
                "WHERE id = ?"

        private const val paramSpec = "SELECT teacher_id FROM Teach_Spec " +
                "WHERE speciality_id = ?"

        private const val paramSubj = "SELECT teacher_id FROM Teach_Subj " +
                "WHERE subject_id = ?"
    }

    override fun getById(id: Int, mod: Int) = connection
        .prepareStatement(if (mod == 0) paramSpec else paramSubj)
        .apply { setInt(1, id) }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    res.next()

                    connection
                        .prepareStatement(filtered)
                        .apply { setInt(1, res.getInt("teacher_id")) }
                        .use { stm ->
                            stm
                                .executeQuery()
                                .use { res ->
                                    mutableListOf<Teacher>()
                                        .apply {
                                            while (res.next()) {
                                                add(
                                                    Teacher(
                                                        res.getInt("id"),
                                                        res.getString("f_name"),
                                                        res.getString("s_name"),
                                                        res.getString("m_name"),
                                                        res.getString("info"),
                                                        arrayOf(),
                                                        arrayOf(),
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
                    mutableListOf<Teacher>()
                        .apply {
                            while (res.next()) {
                                val id = res.getInt("id")

                                add(
                                    Teacher(
                                        id,
                                        res.getString("f_name"),
                                        res.getString("s_name"),
                                        res.getString("m_name"),
                                        res.getString("info"),
                                        Database.specialityRepository.getById(id),
                                        Database.subjectRepository.getById(id),
                                    )
                                )
                            }
                        }
                        .toTypedArray()
                }
        }

    override fun update(vararg args: Either<String, Int>?) = action(update, *args)
    fun add(vararg args: Either<String, Int>) = action(add, *args)
    fun remove(id: Int) = action(remove, Either.Right(id))
    fun nextId() = nextId(maxId)
}