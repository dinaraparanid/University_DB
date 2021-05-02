package app.core.speciality

import app.core.group.Group
import app.core.polymorphism.Entity
import app.core.teacher.Teacher

internal data class Speciality(
    val id: Int,
    val title: String,
    val groups: Array<Group> = arrayOf(),
    val teachers: Array<Teacher> = arrayOf()
) : Entity {
    override fun id() = id

    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass != other?.javaClass -> false

        else -> {
            other as Speciality

            when {
                id != other.id -> false
                title != other.title -> false
                !groups.contentEquals(other.groups) -> false
                !teachers.contentEquals(other.teachers) -> false
                else -> true
            }
        }
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + groups.contentHashCode()
        result = 31 * result + teachers.contentHashCode()
        return result
    }

    override fun asStringArray() = arrayOf(title)
}
