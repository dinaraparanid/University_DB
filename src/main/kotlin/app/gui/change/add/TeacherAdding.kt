package app.gui.change.add

import app.core.Database

internal class TeacherAdding : AbstractAdding(
    "Add Teacher",
    Database.teacherRepository.nextId(),
    Database.teacherRepository::add,
    "Teacher added",
    "First Name",
    "Second Name",
    "Middle Name",
    "Information"
)