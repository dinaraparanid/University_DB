package app.gui.change.selector

import app.core.group.Group
import app.gui.show.GroupTable

internal class GroupSelector : AbstractSelector<Group>(
    "Select Group",
    GroupTable()
)