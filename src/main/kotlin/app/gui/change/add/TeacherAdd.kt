package app.gui.change.add

import app.core.Database

internal class TeacherAdd : AbstractAdd(
    "Add Teacher",
    Database.teacherRepository.nextId(),
    Database.teacherRepository::add,
    "Teacher added",
    "Add Teacher",
    "First Name",
    "Second Name",
    "Middle Name",
    "Information"
)