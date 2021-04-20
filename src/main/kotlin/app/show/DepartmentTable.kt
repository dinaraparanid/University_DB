package app.show

import app.Database
import app.department.Department

internal class DepartmentTable : ContentTable<Department>(
    "Departments",
    { Database.departmentRepository.all() },
    "title"
)