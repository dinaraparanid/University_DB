package app.change.selector

import app.core.faculty.Faculty
import app.show.FacultyTable

internal class FacultySelector : AbstractSelector<Faculty>(
    "Select Faculty",
    FacultyTable()
)