package app.core

import app.core.department.DepartmentRepository
import app.core.faculty.FacultyRepository
import app.core.group.GroupRepository
import app.core.mark.MarkRepository
import app.core.speciality.SpecialityRepository
import app.core.student.StudentRepository
import app.core.subject.SubjectRepository
import app.core.teacher.TeacherRepository
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
            }/StudentBase.db"
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
    val markRepository = MarkRepository(connection)
}