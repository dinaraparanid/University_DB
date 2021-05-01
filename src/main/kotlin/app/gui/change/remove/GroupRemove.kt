package app.gui.change.remove

import app.core.Database
import app.core.group.Group
import app.gui.change.selector.GroupSelector

internal class GroupRemove : AbstractRemove<Group>(
    "Remove Group",
    GroupSelector(),
    Database.groupRepository::remove,
    "Group removed"
)