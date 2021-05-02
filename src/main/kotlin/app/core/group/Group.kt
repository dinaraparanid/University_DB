package app.core.group

import app.core.Database
import app.core.polymorphism.Entity
import app.core.student.Student
import arrow.core.None
import arrow.core.Some

internal data class Group(
    val id: Int,
    val title: String,
    val specialityId: Int,
    val students: Array<Student> = arrayOf()
) : Entity {
    override fun id() = id

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

    override fun asStringArray() = arrayOf(
        title,
        Database.specialityRepository.getTitleById(specialityId).let {
            when (it) {
                None -> "None"
                is Some -> it.value
            }
        }
    )
}
