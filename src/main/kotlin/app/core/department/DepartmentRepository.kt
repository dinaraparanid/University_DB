package app.core.department

import app.core.Database
import app.core.polymorphism.Entity
import app.core.polymorphism.GettableById
import app.core.polymorphism.Repository
import arrow.core.Either
import java.sql.Connection

internal class DepartmentRepository(private val connection: Connection) :
    Repository(connection),
    GettableById<Department> {
    private companion object SQLCommands {
        private const val all = "SELECT * FROM Department"

        private const val getById = "SELECT * FROM Department " +
                "WHERE id = ?"

        private const val maxId = "SELECT MAX(id) as max_id FROM Department"

        private const val add = "INSERT INTO Department (id, title, faculty_id) " +
                "VALUES (?, ?, ?)"

        private const val update = "UPDATE Department SET " +
                "title = ?, faculty_id = ? " +
                "WHERE id = ?"

        private const val remove = "DELETE FROM Department " +
                "WHERE id = ?"

        private const val getIdByFacId = "SELECT id FROM Department " +
                "WHERE faculty_id = ?"

        private const val getIdBySubjId = "SELECT department_id FROM Subj_Dep " +
                "WHERE subject_id = ?"

        private const val maxIdSubjDep = "SELECT MAX(id) as max_id FROM Subj_Dep"

        private const val addSubject = "INSERT INTO Subj_Dep (id, subject_id, department_id) " +
                "VALUES (?, ?, ?)"

        private const val removeSubject = "DELETE FROM Subj_Dep " +
                "WHERE department_id = ? AND subject_id = ?"
    }

    override fun getById(id: Int, mod: Int) = connection
        .prepareStatement(if (mod == 0) getIdByFacId else getIdBySubjId)
        .apply { setInt(1, id) }
        .use { stm ->
            stm.executeQuery().use { res ->
                when {
                    res.next() -> connection
                        .prepareStatement(getById)
                        .apply { setInt(1, res.getInt(if (mod == 0) "id" else "department_id")) }
                        .use { stm ->
                            stm.executeQuery().use { res ->
                                mutableListOf<Department>().apply {
                                    while (res.next()) {
                                        add(
                                            Department(
                                                res.getInt("id"),
                                                res.getString("title"),
                                                res.getString("faculty_id"),
                                            )
                                        )
                                    }
                                }.toTypedArray()
                            }
                        }

                    else -> arrayOf()
                }
            }
        }

    override fun all() = connection.createStatement().use { stm ->
        stm.executeQuery(all).use { res ->
            mutableListOf<Entity>().apply {
                while (res.next()) {
                    val id = res.getInt("id")

                    add(
                        Department(
                            id,
                            res.getString("title"),
                            res.getString("faculty_id"),
                            Database.subjectRepository.getById(id, 1)
                        )
                    )
                }
            }.toTypedArray()
        }
    }

    override fun update(vararg args: Either<String, Int>?) = action(update, *args)
    fun add(vararg args: Either<String, Int>?) = action(add, args[0], args[1], null)
    fun remove(id: Int) = action(remove, Either.Right(id))
    fun nextId() = nextId(maxId)

    fun addSubject(subjectId: Int, departmentId: Int) = action(
        addSubject,
        Either.Right(nextId(maxIdSubjDep)),
        Either.Right(subjectId),
        Either.Right(departmentId)
    )

    fun removeSubject(departmentId: Int, subjectId: Int) = action(
        removeSubject,
        Either.Right(departmentId),
        Either.Right(subjectId),
    )
}