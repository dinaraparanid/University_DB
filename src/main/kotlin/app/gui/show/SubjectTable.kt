package app.gui.show

import app.core.Database

internal class SubjectTable : AbstractTable(
    "Subjects",
    Database.subjectRepository::all,
    "Title"
)