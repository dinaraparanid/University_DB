package app.gui.show

import app.core.Database
import app.core.group.Group

internal class GroupTable : AbstractTable<Group>(
    "Groups",
    Database.groupRepository::all,
    "Title",
    "Speciality Title"
) { init { text = "Groups" } }