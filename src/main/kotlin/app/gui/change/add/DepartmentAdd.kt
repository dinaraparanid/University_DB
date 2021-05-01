package app.gui.change.add

import app.core.Database

internal class DepartmentAdd : AbstractAdd(
    "Add Department",
    Database.departmentRepository.nextId(),
    Database.departmentRepository::add,
    "Department added",
    "Title"
)