package app.show

import app.Database
import app.faculty.Faculty

internal class FacultyTable : ContentTable<Faculty>(
    "Faculties",
    { Database.facultyRepository.all() },
    "Title"
) { init { text = "Faculties" } }