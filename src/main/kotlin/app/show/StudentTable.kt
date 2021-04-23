package app.show

import app.core.Database
import app.core.student.Student

internal class StudentTable : ContentTable<Student>(
    "Students",
    { Database.studentRepository.all() },
    "First Name",
    "Second Name",
    "Middle Name"
) { init { text = "Students" } }