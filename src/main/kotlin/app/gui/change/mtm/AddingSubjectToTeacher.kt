package app.gui.change.mtm

import app.gui.change.selector.SubjectSelector
import app.gui.change.selector.TeacherSelector
import app.core.Database
import app.core.subject.Subject
import app.core.teacher.Teacher

internal class AddingSubjectToTeacher : AbstractMTM<Teacher, Subject>(
    TeacherSelector(),
    SubjectSelector(),
    Database.teacherRepository::addSubject,
    "Subject added to Teacher"
)