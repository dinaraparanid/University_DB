package app.gui.change.mtm

import app.gui.change.selector.SubjectSelector
import app.gui.change.selector.TeacherSelector
import app.core.Database
import app.core.subject.Subject
import app.core.teacher.Teacher

internal class RemovingSubjectFromTeacher : AbstractMTM<Teacher, Subject>(
    "Remove Subject from Teacher",
    TeacherSelector(),
    SubjectSelector(),
    Database.teacherRepository::removeSubject,
    "Subject removed from Teacher"
)