package app.teacher

import app.speciality.Speciality
import app.subject.Subject

internal data class Teacher(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val middleName: String,
    val info: String,
    val specialities: Array<Speciality>,
    val subjects: Array<Subject>
) {
    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass != other?.javaClass -> false

        else -> {
            other as Teacher

            when {
                id != other.id -> false
                firstName != other.firstName -> false
                secondName != other.secondName -> false
                middleName != other.middleName -> false
                info != other.info -> false
                !specialities.contentEquals(other.specialities) -> false
                !subjects.contentEquals(other.subjects) -> false
                else -> true
            }
        }
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + firstName.hashCode()
        result = 31 * result + secondName.hashCode()
        result = 31 * result + middleName.hashCode()
        result = 31 * result + info.hashCode()
        result = 31 * result + specialities.contentHashCode()
        result = 31 * result + subjects.contentHashCode()
        return result
    }
}
