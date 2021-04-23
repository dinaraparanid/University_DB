package app.show

import app.core.Database
import app.core.group.Group

internal class GroupTable : ContentTable<Group>(
    "Groups",
    { Database.groupRepository.all() },
    "Title"
) { init { text = "Groups" } }