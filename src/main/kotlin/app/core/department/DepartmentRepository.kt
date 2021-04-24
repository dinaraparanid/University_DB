package app.core.department

import app.core.*
import arrow.core.Either
import java.sql.Connection

internal class DepartmentRepository(private val connection: Connection) : Repository<Department>(connection) {
    companion object SQLCommands {
        private const val all = "SELECT * FROM Department"

        private const val filtered = "SELECT * FROM Department " +
                "WHERE id = ?"

        private const val maxId = "SELECT MAX(id) FROM Department"

        private const val add = "INSERT INTO Department (id, title, faculty_id) " +
                "VALUES (?, ?, ?)"

        private const val update = "UPDATE Department SET " +
                "title = ?, faculty_id = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Department " +
                "WHERE title = ? AND faculty_id = ?"

        private const val paramFac = "SELECT id FROM Department " +
                "WHERE faculty_id = ?"

        private const val paramSubj = "SELECT department_id FROM Subj_Dep " +
                "WHERE subject_id = ?"
    }

    override fun all(id: Int, mod: Int) = connection
        .prepareStatement(if (mod == 0) paramFac else paramSubj)
        .apply { setInt(1, id) }
        .use { stm ->
            stm
                .executeQuery()
                .use { res ->
                    res.next()

                    when {
                        res.isClosed -> arrayOf()

                        else -> {
                            connection
                                .prepareStatement(filtered)
                                .apply { setInt(1, res.getInt(if (mod == 0) "id" else "department_id")) }
                                .use { stm ->
                                    stm
                                        .executeQuery()
                                        .use { res ->
                                            mutableListOf<Department>()
                                                .apply {
                                                    while (res.next()) {
                                                        add(
                                                            Department(
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
                                    Department(
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

    fun add(vararg args: Either<String, Int>?) = action(add, args[0], args[1], null)
    fun remove(vararg args: Either<String, Int>) = action(remove, *args)
    fun update(vararg args: Either<String, Int>) = action(update, *args)
    fun nextId() = nextId(maxId)
}