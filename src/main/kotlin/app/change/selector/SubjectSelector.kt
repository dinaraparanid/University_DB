package app.change.selector

import app.core.subject.Subject
import app.show.SubjectTable

internal class SubjectSelector : AbstractSelector<Subject>(
    "Select Subject",
    SubjectTable()
)