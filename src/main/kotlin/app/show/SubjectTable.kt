package app.show

import app.Database
import app.subject.Subject

internal class SubjectTable : ContentTable<Subject>(
    "Subjects",
    { Database.subjectRepository.all() },
    "Title"
)