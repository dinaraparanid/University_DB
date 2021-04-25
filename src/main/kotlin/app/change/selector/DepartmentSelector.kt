package app.change.selector

import app.core.department.Department
import app.show.DepartmentTable

internal class DepartmentSelector : AbstractSelector<Department>(
    "Select Department",
    DepartmentTable()
)