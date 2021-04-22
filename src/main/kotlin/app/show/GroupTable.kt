package app.show

import app.Database
import app.group.Group

internal class GroupTable : ContentTable<Group>(
    "Groups",
    { Database.groupRepository.all() },
    "Title"
) { init { text = "Groups" } }