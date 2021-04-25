package app.core.student

import app.core.polymorphism.GetById
import app.core.polymorphism.Repository
import arrow.core.Either
import java.sql.Connection

internal class StudentRepository(private val connection: Connection) :
    Repository<Student>(connection),
    GetById<Student> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Student"

        private const val maxId = "SELECT MAX(id) as max_id FROM Student"

        private const val add = "INSERT INTO Student (id, f_name, s_name, m_name, group_id, info) " +
                "VALUES (?, ?, ?, ?, ?, ?)"

        private const val update = "UPDATE Student SET " +
                "f_name = ?, s_name = ?, m_name = ?, group_id = ?, info = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Student " +
                "WHERE id = ?"

        private const val param = "SELECT * FROM Student " +
                "WHERE group_id = ?"
    }

    override fun getById(id: Int, mod: Int) = connection
        .prepareStatement(param)
        .apply { setInt(1, id) }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    mutableListOf<Student>()
                        .apply {
                            while (res.next()) {
                                add(
                                    Student(
                                        res.getInt("id"),
                                        res.getString("f_name"),
                                        res.getString("s_name"),
                                        res.getString("m_name"),
                                        res.getInt("group_id"),
                                        res.getString("info")
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
                    mutableListOf<Student>()
                        .apply {
                            while (res.next()) {
                                add(
                                    Student(
                                        res.getInt("id"),
                                        res.getString("f_name"),
                                        res.getString("s_name"),
                                        res.getString("m_name"),
                                        res.getInt("group_id"),
                                        res.getString("info")
                                    )
                                )
                            }
                        }
                        .toTypedArray()
                }
        }

    fun add(vararg args: Either<String, Int>) = action(add, args[0], args[1], args[2], args[3], null, args[4])
    fun remove(vararg args: Either<String, Int>?) = action(remove, *args)
    fun update(vararg args: Either<String, Int>) = action(update, *args)
    fun nextId() = nextId(maxId)
}