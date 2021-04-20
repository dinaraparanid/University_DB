package app.student

import app.StringContent

internal data class Student(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val middleName: String,
    val groupId: Int,
    val info: String,
) : StringContent<Student> {
    override fun asStringArray() = arrayOf(firstName, secondName, middleName)
}