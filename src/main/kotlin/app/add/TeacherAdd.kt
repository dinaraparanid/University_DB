package app.add

import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some

internal class TeacherAdd : AbstractAdd(
    "Add Teacher",
    "First Name",
    "Second Name",
    "Middle Name",
    "Information"
) {
    init {
        text = "Add Student"

        super.ok.addActionListener { e ->
            if (e?.source === super.ok) {
                when (
                    Database.teacherRepository.add(
                        Either.Right(Database.teacherRepository.nextId()),
                        Either.Left(super.texts[0].text),
                        Either.Left(super.texts[1].text),
                        Either.Left(super.texts[2].text),
                        Either.Left(super.texts[3].text),
                    )
                ) {
                    None -> failureMessage()
                    is Some -> successMessage("Teacher added")
                }
            }
        }
    }
}