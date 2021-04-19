package app.student

import app.Repository
import java.io.Serializable
import java.sql.Connection
import javax.swing.JOptionPane

internal class StudentRepository(private val connection: Connection) : Repository<Student> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Student"

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

    private val self = "Student"

    override fun all(id: Int, mod: Int) = connection
        .prepareStatement(param)
        .apply {
            setInt(1, id)
        }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    mutableListOf<Student>()
                        .apply {
                            while (res.next()) {
                                add(
                                    app.student.Student(
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
                                    app.student.Student(
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

    override fun add(vararg args: Serializable) = connection
        .prepareStatement(add)
        .apply {
            setInt(1, args[0] as Int)       // id
            setString(2, args[1] as String) // first name
            setString(3, args[2] as String) // second name
            setString(4, args[3] as String) // middle name
            setInt(5, args[4] as Int)       // group id
            setString(6, args[5] as String) // info
        }
        .use { stm ->
            try {
                stm.execute()

                JOptionPane.showMessageDialog(
                    null,
                    "Success",
                    "$self added",
                    JOptionPane.INFORMATION_MESSAGE
                )
            } catch (e: Exception) {
                JOptionPane.showMessageDialog(
                    null,
                    "Something went wrong",
                    "Failure",
                    JOptionPane.INFORMATION_MESSAGE
                )
            }
        }

    override fun update(vararg args: Serializable) = connection
        .prepareStatement(update)
        .apply {
            setString(1, args[0] as String) // first name
            setString(2, args[1] as String) // second name
            setString(3, args[2] as String) // middle name
            setInt(4, args[3] as Int)       // group id
            setString(5, args[4] as String) // info
            setInt(6, args[5] as Int)       // id
        }
        .use { stm ->
            try {
                stm.execute()

                JOptionPane.showMessageDialog(
                    null,
                    "Success",
                    "$self updated",
                    JOptionPane.INFORMATION_MESSAGE
                )
            } catch (e: Exception) {
                JOptionPane.showMessageDialog(
                    null,
                    "Something went wrong",
                    "Failure",
                    JOptionPane.INFORMATION_MESSAGE
                )
            }
        }

    override fun remove(vararg args: Serializable) = connection
        .prepareStatement(remove)
        .apply {
            setString(1, args[0] as String) // first name
            setString(2, args[1] as String) // second name
            setString(3, args[2] as String) // middle name
            setInt(4, args[3] as Int)       // group id
        }
        .use { stm ->
            try {
                stm.execute()

                JOptionPane.showMessageDialog(
                    null,
                    "Success",
                    "$self removed",
                    JOptionPane.INFORMATION_MESSAGE
                )
            } catch (e: Exception) {
                JOptionPane.showMessageDialog(
                    null,
                    "Something went wrong",
                    "Failure",
                    JOptionPane.INFORMATION_MESSAGE
                )
            }
        }
}