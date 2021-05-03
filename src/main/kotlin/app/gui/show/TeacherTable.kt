package app.gui.show

import app.core.Database

internal class TeacherTable : AbstractTable(
    "Teachers",
    Database.teacherRepository::all,
    "First Name",
    "Second Name",
    "Middle Name",
)