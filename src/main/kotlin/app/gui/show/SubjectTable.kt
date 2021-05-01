package app.gui.show

import app.core.Database
import app.core.subject.Subject

internal class SubjectTable : AbstractTable<Subject>(
    "Subjects",
    Database.subjectRepository::all,
    "Title"
) { init { text = "Subjects" } }