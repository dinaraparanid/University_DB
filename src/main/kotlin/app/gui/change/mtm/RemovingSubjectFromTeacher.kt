package app.gui.change.mtm

import app.gui.change.selector.SubjectSelector
import app.gui.change.selector.TeacherSelector
import app.core.Database

internal class RemovingSubjectFromTeacher : AbstractMTM(
    TeacherSelector(),
    SubjectSelector(),
    Database.teacherRepository::removeSubject,
    "Subject removed from Teacher"
)