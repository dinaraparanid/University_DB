package app.change.update

import app.change.selector.FacultySelector
import app.core.Database
import app.core.faculty.Faculty

internal class FacultyUpdate : AbstractUpdateTitle<Faculty>(
    "Update Faculty",
    FacultySelector(),
    Database.facultyRepository,
) { init { text = "Update Faculty" } }