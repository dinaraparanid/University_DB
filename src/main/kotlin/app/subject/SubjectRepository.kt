package app.subject

import app.Database
import app.Repository
import java.io.Serializable
import java.sql.Connection
import javax.swing.JOptionPane

internal class SubjectRepository(private val connection: Connection) : Repository<Subject> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Subject"

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

    private val self = "Subject"

    override fun all(id: Int, mod: Int) = connection
        .prepareStatement(if (mod == 0) paramTeach else paramDep)
        .apply {
            setInt(1, id)
        }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    mutableListOf<Subject>()
                        .apply {
                            while (res.next()) {
                                add(
                                    app.subject.Subject(
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
                    mutableListOf<Subject>()
                        .apply {
                            while (res.next()) {
                                val id = res.getInt("id")

                                add(
                                    app.subject.Subject(
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