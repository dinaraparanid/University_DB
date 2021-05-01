package app.gui.change.add

import app.core.Database

internal class FacultyAdd : AbstractAdd(
    "Add Faculty",
    Database.facultyRepository.nextId(),
    Database.facultyRepository::add,
    "Faculty added",
    "Title"
)