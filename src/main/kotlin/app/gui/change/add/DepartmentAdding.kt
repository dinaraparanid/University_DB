package app.gui.change.add

import app.core.Database

internal class DepartmentAdding : AbstractAdding(
    "Add Department",
    Database.departmentRepository.nextId(),
    Database.departmentRepository::add,
    "Department added",
    "Title"
)