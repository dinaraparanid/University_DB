package app.core.mark

import app.core.polymorphism.Entity
import app.core.polymorphism.Repository
import arrow.core.Either
import java.lang.Exception
import java.sql.Connection

internal class MarkRepository(private val connection: Connection) : Repository(connection) {
    private companion object SQLCommands {
        private const val all = "SELECT * FROM Mark"

        private const val allByStudent = "SELECT * FROM Mark " +
                "WHERE student_id = ?"

        private const val add = "INSERT INTO Mark (id, mark, student_id, subject_id, date) " +
                "VALUES (?, ?, ?, ?, ?)"

        private const val update = "UPDATE Mark SET " +
                "mark = ? " +
                "WHERE student_id = ?, subject_id = ?, date = ?"

        private const val remove = "DELETE FROM Mark " +
                "WHERE student_id = ?, subject_id = ?, date = ?"

        private const val maxId = "SELECT MAX(id) as max_id FROM Mark"
    }

    override fun all() = connection.createStatement().use { stm ->
        stm.executeQuery(all).use { res ->
            mutableListOf<Entity>().apply {
                while (res.next()) {
                    add(
                        Mark(
                            res.getInt("id"),
                            res.getInt("mark"),
                            res.getInt("student_id"),
                            res.getInt("subject_id"),
                            res.getString("date")
                        )
                    )
                }
            }.toTypedArray()
        }
    }

    override fun update(vararg args: Either<String, Int>?) = action(update, *args)

    fun allByStudent(studentId: Int) = connection
        .prepareStatement(allByStudent)
        .apply { setInt(1, studentId) }
        .use { stm ->
            try {
                stm.executeQuery(all).use { res ->
                    mutableListOf<Mark>().apply {
                        while (res.next()) {
                            add(
                                Mark(
                                    res.getInt("id"),
                                    res.getInt("mark"),
                                    res.getInt("student_id"),
                                    res.getInt("subject_id"),
                                    res.getString("date")
                                )
                            )
                        }
                    }.toTypedArray()
                }
            } catch (e: Exception) {
                arrayOf()
            }
        }

    fun add(vararg args: Either<String, Int>) = action(add, *args)
    fun remove(vararg args: Either<String, Int>?) = action(remove, *args)
    fun nextId() = nextId(maxId)
}