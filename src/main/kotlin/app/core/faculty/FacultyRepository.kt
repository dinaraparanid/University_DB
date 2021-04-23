package app.core.faculty

import app.core.*
import app.core.Repository.Arg
import java.sql.Connection

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

    override fun all(id: Int, mod: Int) = arrayOf<Faculty>()

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

    override fun add(vararg args: Arg) = connection
        .prepareStatement(add)
        .apply {
            setInt(1, args[0].parseIntArg())    // id
            setString(2, args[1].parseStrArg()) // title
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
            setString(1, args[0].parseStrArg()) // title
            setInt(2, args[1].parseIntArg())    // id
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
        .apply { setString(1, args[0].parseStrArg()) } // title
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