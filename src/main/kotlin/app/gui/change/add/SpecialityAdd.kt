package app.gui.change.add

import app.core.Database

internal class SpecialityAdd : AbstractAdd(
    "Add Speciality",
    Database.specialityRepository.nextId(),
    Database.studentRepository::add,
    "Speciality added",
    "Title"
)