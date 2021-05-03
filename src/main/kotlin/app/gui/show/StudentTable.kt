package app.gui.show

import app.core.Database

internal class StudentTable : AbstractTable(
    "Students",
    Database.studentRepository::all,
    "First Name",
    "Second Name",
    "Middle Name",
    "Group Title"
)