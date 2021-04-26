package app.change.update

import app.change.selector.SubjectSelector
import app.core.Database
import app.core.subject.Subject

internal class SubjectUpdate : AbstractUpdateTitle<Subject>(
    "Update Subject",
    SubjectSelector(),
    Database.subjectRepository,
) { init { text = "Update Subject" } }