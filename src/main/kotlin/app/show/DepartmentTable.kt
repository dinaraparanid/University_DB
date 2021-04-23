package app.show

import app.core.Database
import app.core.department.Department

internal class DepartmentTable : ContentTable<Department>(
    "Departments",
    { Database.departmentRepository.all() },
    "Title"
) { init { text = "Departments" } }