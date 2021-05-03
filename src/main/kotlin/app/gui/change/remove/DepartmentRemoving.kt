package app.gui.change.remove

import app.gui.change.selector.DepartmentSelector
import app.core.Database

internal class DepartmentRemoving : AbstractRemoving(
    DepartmentSelector(),
    Database.departmentRepository::remove,
    "Department removed"
)