package app.core.student

import app.core.polymorphism.StringContent

internal data class Student(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val middleName: String,
    val groupId: Int,
    val info: String,
) : StringContent {
    override fun asStringArray() = arrayOf(firstName, secondName, middleName)
}