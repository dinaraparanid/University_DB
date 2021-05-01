package app.gui.change.remove

import app.gui.change.selector.SubjectSelector
import app.core.Database
import app.core.subject.Subject

internal class SubjectRemove : AbstractRemove<Subject>(
    "Remove Subject",
    SubjectSelector(),
    Database.subjectRepository::remove,
    "Subject removed"
)