package app.gui.change.remove

import app.core.Database
import app.core.student.Student
import app.gui.change.selector.StudentSelector

internal class StudentRemoving : AbstractRemoving<Student>(
    StudentSelector(),
    Database.studentRepository::remove,
    "Student removed"
)