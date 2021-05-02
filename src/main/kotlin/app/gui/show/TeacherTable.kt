package app.gui.show

import app.core.Database
import app.core.teacher.Teacher

internal class TeacherTable : AbstractTable<Teacher>(
    "Teachers",
    Database.teacherRepository::all,
    "First Name",
    "Second Name",
    "Middle Name",
)