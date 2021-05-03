package app.core.student

import app.core.Database
import app.core.date.Date
import app.core.mark.Mark
import app.core.polymorphism.*
import app.core.subject.Subject
import arrow.core.Either
import java.sql.Connection

internal class StudentRepository(private val connection: Connection) :
    Repository(connection),
    GettableById<Student>,
    GettableIdByParams {
    private companion object SQLCommands {
        private const val all = "SELECT * FROM Student"

        private const val maxId = "SELECT MAX(id) as max_id FROM Student"

        private const val add = "INSERT INTO Student (id, f_name, s_name, m_name, group_id, info) " +
                "VALUES (?, ?, ?, ?, ?, ?)"

        private const val update = "UPDATE Student SET " +
                "f_name = ?, s_name = ?, m_name = ?, group_id = ?, info = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Student " +
                "WHERE id = ?"

        private const val getByGroupId = "SELECT * FROM Student " +
                "WHERE group_id = ?"
    }

    override fun getById(id: Int, mod: Int) = connection
        .prepareStatement(getByGroupId)
        .apply { setInt(1, id) }
        .use { stm ->
            stm.executeQuery().use { res ->
                mutableListOf<Student>().apply {
                    while (res.next()) {
                        add(
                            Student(
                                res.getInt("id"),
                                res.getString("f_name"),
                                res.getString("s_name"),
                                res.getString("m_name"),
                                res.getInt("group_id"),
                                res.getString("info"),
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
                        Student(
                            id,
                            res.getString("f_name"),
                            res.getString("s_name"),
                            res.getString("m_name"),
                            res.getInt("group_id"),
                            res.getString("info"),
                            hashMapOf<Subject, HashMap<Date, MutableList<Mark>>>().also { marks ->
                                Database.markRepository.allByStudent(id).map {
                                    val subject = Database.subjectRepository.getById(it.subjectId).orNull()!!
                                    val date = Date.fromStr(it.date).orNull()!!

                                    marks.getOrPut(subject) { hashMapOf() }

                                    marks[subject]!![date] = marks[subject]!!
                                        .getOrPut(date) { mutableListOf() }
                                        .apply { add(it) }
                                }
                            }.map { (subject, x) ->
                                subject to x.map { (date, marks) ->
                                    date to marks.toList().toTypedArray()
                                }.toMap()
                            }.toMap()
                        )
                    )
                }
            }.toTypedArray()
        }
    }

    override fun update(vararg args: Either<String, Int>?) = action(update, *args)

    fun add(vararg args: Either<String, Int>?) = action(add, args[0], args[1], args[2], args[3], null, args[4])
    fun remove(id: Int) = action(remove, Either.Right(id))
    fun nextId() = nextId(maxId)
}