package app.gui.show

import app.core.Database

internal class DepartmentTable : AbstractTable(
    "Departments",
    Database.departmentRepository::all,
    "Title"
)