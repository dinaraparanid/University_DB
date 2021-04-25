package app.change.selector

import app.core.group.Group
import app.show.GroupTable

internal class GroupSelector : AbstractSelector<Group>(
    "Select Group",
    GroupTable()
)