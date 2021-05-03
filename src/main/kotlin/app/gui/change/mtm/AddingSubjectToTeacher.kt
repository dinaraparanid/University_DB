package app.gui.change.mtm

import app.gui.change.selector.SubjectSelector
import app.gui.change.selector.TeacherSelector
import app.core.Database

internal class AddingSubjectToTeacher : AbstractMTM(
    TeacherSelector(),
    SubjectSelector(),
    Database.teacherRepository::addSubject,
    "Subject added to Teacher"
)