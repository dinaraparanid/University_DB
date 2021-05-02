package app.gui.change.mtm

import app.gui.change.selector.DepartmentSelector
import app.gui.change.selector.SubjectSelector
import app.core.Database
import app.core.department.Department
import app.core.subject.Subject

internal class RemovingSubjectFromDepartment : AbstractMTM<Department, Subject>(
    DepartmentSelector(),
    SubjectSelector(),
    Database.departmentRepository::removeSubject,
    "Subject removed from Department"
)