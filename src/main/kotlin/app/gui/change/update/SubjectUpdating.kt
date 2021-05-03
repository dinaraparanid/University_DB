package app.gui.change.update

import app.gui.change.selector.SubjectSelector
import app.core.Database

internal class SubjectUpdating : AbstractUpdating(
    "Update Subject",
    SubjectSelector(),
    Database.subjectRepository::update,
    "Subject updated",
    "Title"
)