package app.group

import app.StringContent
import app.student.Student

internal data class Group(
    val id: Int,
    val title: String,
    val specialityId: Int,
    val students: Array<Student>
) : StringContent {
    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass != other?.javaClass -> false
        else -> {
            other as Group

            when {
                id != other.id -> false
                title != other.title -> false
                specialityId != other.specialityId -> false
                !students.contentEquals(other.students) -> false
                else -> true
            }
        }
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + specialityId
        result = 31 * result + students.contentHashCode()
        return result
    }

    override fun asStringArray() = arrayOf(title)
}
