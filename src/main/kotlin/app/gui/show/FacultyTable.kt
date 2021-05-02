package app.gui.show

import app.core.Database
import app.core.faculty.Faculty

internal class FacultyTable : AbstractTable<Faculty>(
    "Faculties",
    Database.facultyRepository::all,
    "Title"
)