package app.gui.change.mtm

import app.gui.change.selector.DepartmentSelector
import app.gui.change.selector.SubjectSelector
import app.core.Database
import app.core.department.Department
import app.core.subject.Subject

internal class AddingSubjectToDepartment : AbstractMTM<Department, Subject>(
    "Add Subject to Department",
    DepartmentSelector(),
    SubjectSelector(),
    Database.departmentRepository::addSubject,
    "Subject added to Department"
)