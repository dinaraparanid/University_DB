package app.core.student

import app.core.polymorphism.StringContent
import app.core.polymorphism.WithId

internal data class Student(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val middleName: String,
    val groupId: Int,
    val info: String,
) : StringContent, WithId {
    override fun id() = id
    override fun asStringArray() = arrayOf(firstName, secondName, middleName)
}