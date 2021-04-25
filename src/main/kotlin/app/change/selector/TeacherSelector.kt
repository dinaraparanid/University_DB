package app.change.selector

import app.core.teacher.Teacher
import app.show.TeacherTable

internal class TeacherSelector : AbstractSelector<Teacher>(
    "Select Teacher",
    TeacherTable()
)