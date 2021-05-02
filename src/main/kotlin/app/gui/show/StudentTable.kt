package app.gui.show

import app.core.Database
import app.core.student.Student

internal class StudentTable : AbstractTable<Student>(
    "Students",
    Database.studentRepository::all,
    "First Name",
    "Second Name",
    "Middle Name",
    "Group Title"
)