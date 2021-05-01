package app.gui.change.selector

import app.core.subject.Subject
import app.gui.show.SubjectTable

internal class SubjectSelector : AbstractSelector<Subject>(
    "Select Subject",
    SubjectTable()
)