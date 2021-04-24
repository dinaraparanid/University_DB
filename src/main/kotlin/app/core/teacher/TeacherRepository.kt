package app.core.teacher

import app.core.*
import app.setValOrNull
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.sql.Connection

internal class TeacherRepository(private val connection: Connection) : Repository<Teacher> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Teacher"

        private const val filtered = "SELECT * FROM Teacher " +
                "WHERE id = ?"

        private const val maxId = "SELECT MAX(id) FROM Teacher"

        private const val add = "INSERT INTO Teacher (id, f_name, s_name, m_name, info) " +
                "VALUES (?, ?, ?, ?, ?)"

        private const val update = "UPDATE Teacher SET " +
                "f_name = ?, s_name = ?, m_name = ?, info = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Teacher " +
                "WHERE f_name = ? AND s_name = ? AND m_name = ?"

        private const val paramSpec = "SELECT teacher_id FROM Teach_Spec " +
                "WHERE speciality_id = ?"

        private const val paramSubj = "SELECT teacher_id FROM Teach_Subj " +
                "WHERE subject_id = ?"
    }

    override fun all(id: Int, mod: Int) = connection
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
                                        Database.specialityRepository.all(id),
                                        Database.subjectRepository.all(id),
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
            setValOrNull(5, args[4]) // info
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
            setValOrNull(4, args[3]) // info
            setValOrNull(5, args[4]) // id
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