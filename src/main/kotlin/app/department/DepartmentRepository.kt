package app.department

import app.*
import app.Repository.Arg
import java.sql.Connection

internal class DepartmentRepository(private val connection: Connection) : Repository<Department> {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Department"

        private const val filtered = "SELECT * FROM Department " +
                "WHERE id = ?"

        private const val add = "INSERT INTO Department (id, title, faculty_id) " +
                "VALUES (?, ?, ?)"

        private const val update = "UPDATE Department SET " +
                "title = ?, faculty_id = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Department " +
                "WHERE title = ? AND faculty_id = ?"

        private const val paramFac = "SELECT department_id FROM Department " +
                "WHERE faculty_id = ?"

        private const val paramSubj = "SELECT department_id FROM Subj_Dep " +
                "WHERE subject_id = ?"
    }

    private val self = "Department"

    override fun all(id: Int, mod: Int) = connection
        .prepareStatement(if (mod == 0) paramFac else paramSubj)
        .apply { setInt(1, id) }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    res.next()

                    connection
                        .prepareStatement(filtered)
                        .apply { setInt(1, res.getInt("department_id")) }
                        .use { stm ->
                            stm
                                .executeQuery()
                                .use { res ->
                                    mutableListOf<Department>()
                                        .apply {
                                            while (res.next()) {
                                                add(
                                                    app.department.Department(
                                                        res.getInt("id"),
                                                        res.getString("title"),
                                                        res.getString("faculty_id"),
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
                    mutableListOf<Department>()
                        .apply {
                            while (res.next()) {
                                val id = res.getInt("id")

                                add(
                                    app.department.Department(
                                        id,
                                        res.getString("title"),
                                        res.getString("faculty_id"),
                                        Database.subjectRepository.all(id, 1)
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
            setString(2, args[1].parseStrArg()) // title
            setInt(3, args[2].parseIntArg())    // faculty id
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

    override fun remove(vararg args: Arg) = connection
        .prepareStatement(remove)
        .apply {
            setString(1, args[0].parseStrArg()) // title
            setInt(2, args[1].parseIntArg())    // faculty id
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

    override fun update(vararg args: Arg) = connection
        .prepareStatement(update)
        .apply {
            setString(1, args[0].parseStrArg()) // title
            setInt(2, args[1].parseIntArg())    // faculty id
            setInt(3, args[2].parseIntArg())    // id
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
}