package app.gui.change.remove

import app.gui.change.selector.TeacherSelector
import app.core.Database
import app.core.teacher.Teacher

internal class TeacherRemoving : AbstractRemoving<Teacher>(
    TeacherSelector(),
    Database.teacherRepository::remove,
    "Teacher removed"
)