package app.core.student

import app.core.Database
import app.core.date.Date
import app.core.mark.Mark
import app.core.polymorphism.Entity
import app.core.subject.Subject
import arrow.core.None
import arrow.core.Some

internal data class Student(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val middleName: String,
    val groupId: Int,
    val info: String,
    val marks: Map<Subject, Map<Date, Array<Mark>>> = hashMapOf()
) : Entity {
    override fun id() = id

    override fun asStringArray() = arrayOf(
        firstName,
        secondName,
        middleName,
        Database.groupRepository.getTitleById(groupId).let {
            when (it) {
                None -> "None"
                is Some -> it.value
            }
        }
    )
}