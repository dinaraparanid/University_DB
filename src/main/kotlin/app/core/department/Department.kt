package app.core.department

import app.core.StringContent
import app.core.subject.Subject

internal data class Department(
    val id: Int,
    val title: String,
    val facultyId: String,
    val subjects: Array<Subject>
) : StringContent {
    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass != other?.javaClass -> false

        else -> {
            other as Department

            when {
                id != other.id -> false
                title != other.title -> false
                facultyId != other.facultyId -> false
                !subjects.contentEquals(other.subjects) -> false
                else -> true
            }
        }
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + facultyId.hashCode()
        result = 31 * result + subjects.contentHashCode()
        return result
    }

    override fun asStringArray() = arrayOf(title)
}
