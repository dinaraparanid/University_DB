package app.gui.change.remove

import app.core.Database
import app.gui.change.selector.GroupSelector

internal class GroupRemoving : AbstractRemoving(
    GroupSelector(),
    Database.groupRepository::remove,
    "Group removed"
)