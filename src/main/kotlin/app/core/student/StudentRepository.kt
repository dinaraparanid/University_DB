package app.core.student

import app.core.Repository
import app.setValOrNull
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.sql.Connection

internal class StudentRepository(private val connection: Connection) : Repository<Student> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Student"

        private const val maxId = "SELECT MAX(id) FROM Student"

        private const val add = "INSERT INTO Student (id, f_name, s_name, m_name, group_id, info) " +
                "VALUES (?, ?, ?, ?, ?, ?)"

        private const val update = "UPDATE Student SET " +
                "f_name = ?, s_name = ?, m_name = ?, group_id = ?, info = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Student " +
                "WHERE f_name = ? AND s_name = ? AND m_name = ? AND group_id = ?"

        private const val param = "SELECT * FROM Student " +
                "WHERE group_id = ?"
    }

    override fun all(id: Int, mod: Int) = connection
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

    override fun add(vararg args: Either<String, Int>) = connection
        .prepareStatement(add)
        .apply {
            setValOrNull(1, args[0]) // id
            setValOrNull(2, args[1]) // first name
            setValOrNull(3, args[2]) // second name
            setValOrNull(4, args[3]) // middle name
            setValOrNull(5, null) // group id
            setValOrNull(6, args[4]) // info
        }
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
            setValOrNull(1, args[0]) // first name
            setValOrNull(2, args[1]) // second name
            setValOrNull(3, args[2]) // middle name
            setValOrNull(4, args[3]) // group id
            setValOrNull(5, args[4]) // info
            setValOrNull(6, args[5]) // id
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
        .apply {
            setValOrNull(1, args[0]) // first name
            setValOrNull(2, args[1]) // second name
            setValOrNull(3, args[2]) // middle name
            setValOrNull(4, args[3]) // group id
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