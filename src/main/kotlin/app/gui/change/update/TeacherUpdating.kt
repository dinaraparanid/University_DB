package app.gui.change.update

import app.gui.change.selector.TeacherSelector
import app.core.Database
import app.core.teacher.Teacher

internal class TeacherUpdating : AbstractUpdating<Teacher>(
    "Update Teacher",
    TeacherSelector(),
    Database.teacherRepository::update,
    "Teacher updated",
    "First Name",
    "Second Name",
    "Middle Name",
    "Information"
)