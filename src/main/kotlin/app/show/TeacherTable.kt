package app.show

import app.Database
import app.teacher.Teacher

internal class TeacherTable : ContentTable<Teacher>(
    "Teachers",
    { Database.teacherRepository.all() },
    "First Name",
    "Second Name",
    "Middle Name",
) { init { text = "Teachers" } }