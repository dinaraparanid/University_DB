package app.gui.change.remove

import app.gui.change.selector.FacultySelector
import app.core.Database
import app.core.faculty.Faculty

internal class FacultyRemoving : AbstractRemoving<Faculty>(
    "Remove Faculty",
    FacultySelector(),
    Database.facultyRepository::remove,
    "Faculty removed"
)