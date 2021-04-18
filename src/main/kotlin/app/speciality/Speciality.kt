package app.speciality

import app.group.Group

internal data class Speciality(
    val id: Int,
    val title: String,
    val groups: MutableList<Group>
)
