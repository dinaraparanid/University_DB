package app.gui.change.remove

import app.gui.change.selector.TeacherSelector
import app.core.Database

internal class TeacherRemoving : AbstractRemoving(
    TeacherSelector(),
    Database.teacherRepository::remove,
    "Teacher removed"
)