package app.gui.change.remove

import app.gui.change.selector.DepartmentSelector
import app.core.Database
import app.core.department.Department

internal class DepartmentRemove : AbstractRemove<Department>(
    "Remove Department",
    DepartmentSelector(),
    Database.departmentRepository::remove,
    "Department removed"
)