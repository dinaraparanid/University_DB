package app.subject

import app.StringContent
import app.department.Department
import app.teacher.Teacher

internal data class Subject(
    val id: Int,
    val title: String,
    val teachers: Array<Teacher>,
    val departments: Array<Department>
) : StringContent {
    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass != other?.javaClass -> false
        else -> {
            other as Subject

            when {
                id != other.id -> false
                title != other.title -> false
                !teachers.contentEquals(other.teachers) -> false
                !departments.contentEquals(other.departments) -> false
                else -> true
            }
        }
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + teachers.contentHashCode()
        result = 31 * result + departments.contentHashCode()
        return result
    }

    override fun asStringArray() = arrayOf(title)
}
