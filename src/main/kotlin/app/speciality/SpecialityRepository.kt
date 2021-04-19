package app.speciality

import app.Database
import app.Repository
import java.io.Serializable
import java.sql.Connection
import javax.swing.JOptionPane

internal class SpecialityRepository(private val connection: Connection) : Repository<Speciality> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Speciality"

        private const val add = "INSERT INTO Speciality (id, title) " +
                "VALUES (?, ?)"

        private const val update = "UPDATE Speciality SET " +
                "title = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Speciality " +
                "WHERE title = ?"

        private const val param = "SELECT teacher_id FROM Teach_Spec " +
                "WHERE teacher_id = ?"
    }

    private val self = "Speciality"

    override fun all(id: Int, mod: Int) = connection
        .prepareStatement(param)
        .apply {
            setInt(1, id)
        }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    mutableListOf<Speciality>()
                        .apply {
                            while (res.next()) {
                                add(
                                    Speciality(
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

    override fun all() = connection
        .createStatement()
        .use { stm ->
            stm
                .executeQuery(all)
                .use { res ->
                    mutableListOf<Speciality>()
                        .apply {
                            while (res.next()) {
                                val id = res.getInt("id")

                                add(
                                    Speciality(
                                        id,
                                        res.getString("title"),
                                        Database.groupRepository.all(id),
                                        Database.teacherRepository.all(id)
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
}