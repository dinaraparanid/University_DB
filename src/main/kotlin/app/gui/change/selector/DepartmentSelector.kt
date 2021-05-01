package app.gui.change.selector

import app.core.department.Department
import app.gui.show.DepartmentTable

internal class DepartmentSelector : AbstractSelector<Department>(
    "Select Department",
    DepartmentTable()
)