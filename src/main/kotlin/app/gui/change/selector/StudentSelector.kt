package app.gui.change.selector

import app.core.student.Student
import app.gui.show.StudentTable

internal class StudentSelector : AbstractSelector<Student>(
    "Select Student",
    StudentTable()
)