package app.core.faculty

import app.core.polymorphism.StringContent
import app.core.department.Department
import app.core.polymorphism.WithId

internal data class Faculty(
    val id: Int,
    val title: String,
    val departments: Array<Department>
) : StringContent, WithId {
    override fun id() = id

    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass != other?.javaClass -> false

        else -> {
            other as Faculty

            when {
                id != other.id -> false
                title != other.title -> false
                !departments.contentEquals(other.departments) -> false
                else -> true
            }
        }
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + departments.contentHashCode()
        return result
    }

    override fun asStringArray() = arrayOf(title)
}
