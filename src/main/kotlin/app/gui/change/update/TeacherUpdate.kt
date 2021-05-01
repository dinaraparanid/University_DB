package app.gui.change.update

import app.gui.change.selector.TeacherSelector
import app.core.Database
import app.core.teacher.Teacher

internal class TeacherUpdate : AbstractUpdate<Teacher>(
    "Update Teacher",
    TeacherSelector(),
    Database.teacherRepository::update,
    "First Name",
    "Second Name",
    "Middle Name",
    "Information"
)