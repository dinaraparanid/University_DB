package app.faculty

import app.Database
import app.Repository
import java.io.Serializable
import java.sql.Connection
import javax.swing.JOptionPane

internal class FacultyRepository(private val connection: Connection) : Repository<Faculty> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Faculty"

        private const val add = "INSERT INTO Faculty (id, title) " +
                "VALUES (?, ?)"

        private const val update = "UPDATE Faculty SET " +
                "title = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Faculty " +
                "WHERE title = ?"
    }

    private val self = "Faculty"

    override fun all(id: Int) = mutableListOf<Faculty>()

    override fun all() = connection
        .createStatement()
        .use { stm ->
            stm
                .executeQuery(all)
                .use { res ->
                    mutableListOf<Faculty>()
                        .apply {
                            while (res.next()) {
                                val id = res.getInt("id")

                                add(
                                    Faculty(
                                        id,
                                        res.getString("title"),
                                        Database.departmentRepository.all(id)
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
            setString(2, args[1] as String) // title
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
            setString(1, args[0] as String) // title
            setInt(2, args[1] as Int)       // id
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
            setString(1, args[0] as String) // title
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