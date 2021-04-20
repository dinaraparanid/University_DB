package app.show

import app.Database
import app.student.Student

internal class StudentTable : ContentTable<Student>(
    "Students",
    { Database.studentRepository.all() },
    "First Name",
    "Second Name",
    "Middle Name"
)