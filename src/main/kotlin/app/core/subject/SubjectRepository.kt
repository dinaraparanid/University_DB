package app.core.subject

import app.core.*
import app.setValOrNull
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.sql.Connection

internal class SubjectRepository(private val connection: Connection) : Repository<Subject> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Subject"

        private const val filtered = "SELECT * FROM Subject " +
                "WHERE id = ?"

        private const val maxId = "SELECT MAX(id) FROM Subject"

        private const val add = "INSERT INTO Subject (id, title) " +
                "VALUES (?, ?)"

        private const val update = "UPDATE Subject SET " +
                "title = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Subject " +
                "WHERE title = ?"

        private const val paramTeach = "SELECT teacher_id FROM Teach_Subj " +
                "WHERE subject_id = ?"

        private const val paramDep = "SELECT teacher_id FROM Subj_Dep " +
                "WHERE subject_id = ?"
    }

    override fun all(id: Int, mod: Int) = connection
        .prepareStatement(if (mod == 0) paramTeach else paramDep)
        .apply { setInt(1, id) }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    res.next()

                    connection
                        .prepareStatement(filtered)
                        .apply { res.getInt("subject_id") }
                        .use { stm ->
                            stm
                                .executeQuery()
                                .use { res ->
                                    mutableListOf<Subject>()
                                        .apply {
                                            while (res.next()) {
                                                add(
                                                    Subject(
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
                    mutableListOf<Subject>()
                        .apply {
                            while (res.next()) {
                                val id = res.getInt("id")

                                add(
                                    Subject(
                                        id,
                                        res.getString("title"),
                                        Database.teacherRepository.all(id, 1),
                                        Database.departmentRepository.all(id)
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