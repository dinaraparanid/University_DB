package app.group

import app.student.Student

internal data class Group(
    val id: Int,
    val title: String,
    val specialityId: Int,
    val students: MutableList<Student>
)
