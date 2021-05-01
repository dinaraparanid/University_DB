package app.gui.change.update

import app.gui.change.selector.SubjectSelector
import app.core.Database
import app.core.subject.Subject

internal class SubjectUpdate : AbstractUpdate<Subject>(
    "Update Subject",
    SubjectSelector(),
    Database.subjectRepository::update,
) { init { text = "Update Subject" } }