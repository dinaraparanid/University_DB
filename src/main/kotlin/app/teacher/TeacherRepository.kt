package app.teacher

import app.Repository
import java.io.Serializable
import java.sql.Connection
import javax.swing.JOptionPane

internal class TeacherRepository(private val connection: Connection) : Repository<Teacher> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Teacher"

        private const val add = "INSERT INTO Teacher (id, f_name, s_name, m_name, info) " +
                "VALUES (?, ?, ?, ?, ?)"

        private const val update = "UPDATE Teacher SET " +
                "f_name = ?, s_name = ?, m_name = ?, info = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Teacher " +
                "WHERE f_name = ? AND s_name = ? AND m_name = ?"
    }

    private val self = "Teacher"

    override fun all(id: Int): MutableList<Teacher> {
        TODO()
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
                                add(
                                    Teacher(
                                        res.getInt("id"),
                                        res.getString("f_name"),
                                        res.getString("s_name"),
                                        res.getString("m_name"),
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
            setString(5, args[4] as String) // info
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
            setString(4, args[3] as String) // info
            setInt(5, args[4] as Int)       // id
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