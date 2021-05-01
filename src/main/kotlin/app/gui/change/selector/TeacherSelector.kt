package app.gui.change.selector

import app.core.teacher.Teacher
import app.gui.show.TeacherTable

internal class TeacherSelector : AbstractSelector<Teacher>(
    "Select Teacher",
    TeacherTable()
)