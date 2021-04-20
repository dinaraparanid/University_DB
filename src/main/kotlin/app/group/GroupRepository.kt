package app.group

import app.Database
import app.Repository
import java.io.Serializable
import java.sql.Connection
import javax.swing.JOptionPane

internal class GroupRepository(private val connection: Connection) : Repository<Group> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Groups"

        private const val add = "INSERT INTO Groups (id, title, speciality_id) " +
                "VALUES (?, ?, ?)"

        private const val update = "UPDATE Groups SET " +
                "title = ?, speciality_id = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Groups " +
                "WHERE title = ? AND speciality_id = ?"

        private const val param = "SELECT * FROM Groups " +
                "WHERE speciality_id = ?"
    }

    private val self = "Group"

    override fun all(id: Int, mod: Int) = connection
        .prepareStatement(param)
        .apply {
            setInt(1, id)
        }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    mutableListOf<Group>()
                        .apply {
                            while (res.next()) {
                                add(
                                    app.group.Group(
                                        res.getInt("id"),
                                        res.getString("title"),
                                        res.getInt("speciality_id"),
                                        arrayOf()
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
                    mutableListOf<Group>()
                        .apply {
                            while (res.next()) {
                                val id = res.getInt("id")

                                add(
                                    app.group.Group(
                                        id,
                                        res.getString("title"),
                                        res.getInt("speciality_id"),
                                        Database.studentRepository.all(id)
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
            setString(3, args[2] as String) // speciality id
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
            setString(2, args[1] as String) // speciality id
            setInt(3, args[2] as Int)       // id
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
            setString(2, args[1] as String) // speciality id
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