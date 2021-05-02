package app.gui.change.add

import app.core.Database

internal class GroupAdding : AbstractAdding(
    "Add Group",
    Database.groupRepository.nextId(),
    Database.groupRepository::add,
    "Group added",
    "Title"
)