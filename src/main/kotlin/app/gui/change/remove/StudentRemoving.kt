package app.gui.change.remove

import app.core.Database
import app.gui.change.selector.StudentSelector

internal class StudentRemoving : AbstractRemoving(
    StudentSelector(),
    Database.studentRepository::remove,
    "Student removed"
)