package app.show

import app.core.Database
import app.core.faculty.Faculty

internal class FacultyTable : ContentTable<Faculty>(
    "Faculties",
    { Database.facultyRepository.all() },
    "Title"
) { init { text = "Faculties" } }