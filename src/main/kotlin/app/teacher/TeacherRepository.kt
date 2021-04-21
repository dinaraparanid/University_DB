package app.teacher

import app.*
import app.Repository.Arg
import java.sql.Connection
import javax.swing.JOptionPane

internal class TeacherRepository(private val connection: Connection) : Repository<Teacher> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Teacher"

        private const val filtered = "SELECT * FROM Teacher " +
                "WHERE id = ?"

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

    private val self = "Teacher"

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
                                                    app.teacher.Teacher(
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
                                    app.teacher.Teacher(
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

    override fun add(vararg args: Arg) = connection
        .prepareStatement(add)
        .apply {
            setInt(1, args[0].parseIntArg())    // id
            setString(2, args[1].parseStrArg()) // first name
            setString(3, args[2].parseStrArg()) // second name
            setString(4, args[3].parseStrArg()) // middle name
            setString(5, args[4].parseStrArg()) // info
        }
        .use { stm ->
            try {
                stm.execute().run {}

                /*JOptionPane.showMessageDialog(
                    null,
                    "Success",
                    "$self added",
                    JOptionPane.INFORMATION_MESSAGE
                )*/
            } catch (e: Exception) {
                null
                /*JOptionPane.showMessageDialog(
                    null,
                    "Something went wrong",
                    "Failure",
                    JOptionPane.INFORMATION_MESSAGE
                )*/
            }
        }

    override fun update(vararg args: Arg) = connection
        .prepareStatement(update)
        .apply {
            setString(1, args[0].parseStrArg()) // first name
            setString(2, args[1].parseStrArg()) // second name
            setString(3, args[2].parseStrArg()) // middle name
            setString(4, args[3].parseStrArg()) // info
            setInt(5, args[4].parseIntArg())    // id
        }
        .use { stm ->
            try {
                stm.execute().run {}

                /*JOptionPane.showMessageDialog(
                    null,
                    "Success",
                    "$self updated",
                    JOptionPane.INFORMATION_MESSAGE
                )*/
            } catch (e: Exception) {
                null
                /*JOptionPane.showMessageDialog(
                    null,
                    "Something went wrong",
                    "Failure",
                    JOptionPane.INFORMATION_MESSAGE
                )*/
            }
        }

    override fun remove(vararg args: Arg) = connection
        .prepareStatement(remove)
        .apply {
            setString(1, args[0].parseStrArg()) // first name
            setString(2, args[1].parseStrArg()) // second name
            setString(3, args[2].parseStrArg()) // middle name
        }
        .use { stm ->
            try {
                stm.execute().run {}

                /*JOptionPane.showMessageDialog(
                    null,
                    "Success",
                    "$self removed",
                    JOptionPane.INFORMATION_MESSAGE
                )*/
            } catch (e: Exception) {
                null
                /*JOptionPane.showMessageDialog(
                    null,
                    "Something went wrong",
                    "Failure",
                    JOptionPane.INFORMATION_MESSAGE
                )*/
            }
        }
}