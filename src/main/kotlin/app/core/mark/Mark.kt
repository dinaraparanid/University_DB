package app.core.mark

import app.core.polymorphism.Entity

internal data class Mark(
    val id: Int,
    val mark: Int,
    val studentId: Int,
    val subjectId: Int,
    val date: String
) : Entity {
    override fun id() = id
    override fun asStringArray() = arrayOf("$mark")
}
