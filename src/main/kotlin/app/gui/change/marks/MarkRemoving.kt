package app.gui.change.marks

import app.core.Database

internal class MarkRemoving : AbstractChange(
    "Remove Mark",
    Database.markRepository::remove,
    "Mark removed"
)