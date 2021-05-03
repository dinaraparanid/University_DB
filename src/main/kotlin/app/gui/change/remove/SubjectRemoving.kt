package app.gui.change.remove

import app.gui.change.selector.SubjectSelector
import app.core.Database

internal class SubjectRemoving : AbstractRemoving(
    SubjectSelector(),
    Database.subjectRepository::remove,
    "Subject removed"
)