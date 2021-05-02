package app.gui.change.update

import app.gui.change.selector.FacultySelector
import app.core.Database
import app.core.faculty.Faculty

internal class FacultyUpdating : AbstractUpdating<Faculty>(
    "Update Faculty",
    FacultySelector(),
    Database.facultyRepository::update,
    "Title"
) { init { text = "Update Faculty" } }