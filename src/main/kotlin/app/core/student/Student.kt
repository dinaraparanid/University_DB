package app.core.student

import app.core.Database
import app.core.mark.Mark
import app.core.polymorphism.Entity
import app.core.subject.Subject

internal data class Student(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val middleName: String,
    val groupId: Int,
    val info: String,
    val marks: HashMap<Subject, HashMap<String, Mark>>
) : Entity() {
    override fun id() = id

    override fun asStringArray() = arrayOf(
        firstName,
        secondName,
        middleName,
        Database.groupRepository.getTitleById(groupId)
    )
}