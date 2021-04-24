package app.add

import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some

internal class FacultyAdd : AbstractAdd(
    "Add Faculty",
    "Title"
) {
    init {
        text = "Add Faculty"

        super.ok.addActionListener { e ->
            if (e?.source === super.ok) {
                when (
                    Database.facultyRepository.add(
                        Either.Right(Database.facultyRepository.nextId()),
                        Either.Left(super.texts[0].text)
                    )
                ) {
                    None -> failureMessage()
                    is Some -> successMessage("Faculty added")
                }
            }
        }
    }
}