package app.gui.show

import app.core.Database
import app.core.department.Department

internal class DepartmentTable : AbstractTable<Department>(
    "Departments",
    Database.departmentRepository::all,
    "Title"
) { init { text = "Departments" } }