package app.gui.change.add

import app.core.Database

internal class StudentAdding : AbstractAdding(
    "Add Student",
    Database.studentRepository.nextId(),
    Database.studentRepository::add,
    "Student added",
    "First Name",
    "Second Name",
    "Middle Name",
    "Information"
)