package app.gui.change.selector

import app.core.faculty.Faculty
import app.gui.show.FacultyTable

internal class FacultySelector : AbstractSelector<Faculty>(
    "Select Faculty",
    FacultyTable()
)