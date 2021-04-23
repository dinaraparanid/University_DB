package app.show

import app.core.Database
import app.core.subject.Subject

internal class SubjectTable : ContentTable<Subject>(
    "Subjects",
    { Database.subjectRepository.all() },
    "Title"
) { init { text = "Subjects" } }