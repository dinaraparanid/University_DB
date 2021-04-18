package app

import app.department.DepartmentRepository
import app.faculty.FacultyRepository
import app.group.GroupRepository
import app.speciality.SpecialityRepository
import app.student.StudentRepository
import app.subject.SubjectRepository
import app.teacher.TeacherRepository
import org.sqlite.SQLiteDataSource
import java.io.File

internal object Database {
    private val connection: java.sql.Connection = SQLiteDataSource()
        .apply {
            url = "jdbc:sqlite:${
                File("").absolutePath.replace(
                    "\\",
                    "/"
                )
            }/base.db"
        }
        .connection
        .apply { autoCommit = true }

    val studentRepository = StudentRepository(connection)
    val groupRepository = GroupRepository(connection)
    val specialityRepository = SpecialityRepository(connection)
    val teacherRepository = TeacherRepository(connection)
    val subjectRepository = SubjectRepository(connection)
    val departmentRepository = DepartmentRepository(connection)
    val facultyRepository = FacultyRepository(connection)
}