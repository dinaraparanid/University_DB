package app.change.selector

import app.core.student.Student
import app.show.StudentTable

internal class StudentSelector : AbstractSelector<Student>(
    "Select Student",
    StudentTable()
)