package app.core.student

import app.core.mark.DateTime
import app.core.mark.Mark
import app.core.polymorphism.StringContent
import app.core.polymorphism.WithId
import app.core.subject.Subject

internal data class Student(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val middleName: String,
    val groupId: Int,
    val info: String,
    val marks: HashMap<Subject, HashMap<DateTime, Mark>>
) : StringContent, WithId {
    override fun id() = id
    override fun asStringArray() = arrayOf(firstName, secondName, middleName)
}