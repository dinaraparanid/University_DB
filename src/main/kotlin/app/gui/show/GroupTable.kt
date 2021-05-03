package app.gui.show

import app.core.Database

internal class GroupTable : AbstractTable(
    "Groups",
    Database.groupRepository::all,
    "Title",
    "Speciality Title"
)