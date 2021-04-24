package app.add

import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some

internal class SpecialityAdd : AbstractAdd(
    "Add Speciality",
    "Title"
) {
    init {
        text = "Add Speciality"

        super.ok.addActionListener { e ->
            if (e?.source === super.ok) {
                when (
                    Database.specialityRepository.add(
                        Either.Right(Database.specialityRepository.nextId()),
                        Either.Left(super.texts[0].text)
                    )
                ) {
                    None -> failureMessage()
                    is Some -> successMessage("Speciality added")
                }
            }
        }
    }
}