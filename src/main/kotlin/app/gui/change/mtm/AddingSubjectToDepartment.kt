package app.gui.change.mtm

import app.gui.change.selector.DepartmentSelector
import app.gui.change.selector.SubjectSelector
import app.core.Database

internal class AddingSubjectToDepartment : AbstractMTM(
    DepartmentSelector(),
    SubjectSelector(),
    Database.departmentRepository::addSubject,
    "Subject added to Department"
)