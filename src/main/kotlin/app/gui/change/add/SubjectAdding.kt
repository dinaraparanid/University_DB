package app.gui.change.add

import app.core.Database

internal class SubjectAdding : AbstractAdding(
    "Add Subject",
    Database.subjectRepository.nextId(),
    Database.subjectRepository::add,
    "Subject added",
    "Title"
)