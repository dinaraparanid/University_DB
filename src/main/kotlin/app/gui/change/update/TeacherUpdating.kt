package app.gui.change.update

import app.gui.change.selector.TeacherSelector
import app.core.Database

internal class TeacherUpdating : AbstractUpdating(
    "Update Teacher",
    TeacherSelector(),
    Database.teacherRepository::update,
    "Teacher updated",
    "First Name",
    "Second Name",
    "Middle Name",
    "Information"
)