package app.gui.change.remove

import app.gui.change.selector.FacultySelector
import app.core.Database

internal class FacultyRemoving : AbstractRemoving(
    FacultySelector(),
    Database.facultyRepository::remove,
    "Faculty removed"
)