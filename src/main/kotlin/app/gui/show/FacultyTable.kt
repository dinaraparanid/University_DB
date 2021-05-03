package app.gui.show

import app.core.Database

internal class FacultyTable : AbstractTable(
    "Faculties",
    Database.facultyRepository::all,
    "Title"
)