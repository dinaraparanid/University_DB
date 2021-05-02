package app.gui.change.marks

import app.core.Database

internal class MarkUpdating : AbstractChange(
    "Update Mark",
    Database.markRepository::update,
    "Mark updated"
)