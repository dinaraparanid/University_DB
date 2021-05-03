package app.gui.change.update

import app.gui.change.selector.FacultySelector
import app.core.Database

internal class FacultyUpdating : AbstractUpdating(
    "Update Faculty",
    FacultySelector(),
    Database.facultyRepository::update,
    "Faculty updated",
    "Title"
)