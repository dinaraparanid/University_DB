package app.faculty

import app.department.Department

internal data class Faculty(
    val id: Int,
    val title: String,
    val departments: MutableList<Department>
)
