package app.gui.change.mtm

import app.gui.change.selector.DepartmentSelector
import app.gui.change.selector.SubjectSelector
import app.core.Database

internal class RemovingSubjectFromDepartment : AbstractMTM(
    DepartmentSelector(),
    SubjectSelector(),
    Database.departmentRepository::removeSubject,
    "Subject removed from Department"
)