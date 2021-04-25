package app.change.remove

import app.change.ChangeWindow
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.awt.Rectangle

internal class SpecialityRemove : ChangeWindow(
    "Remove Speciality",
    "Title"
) {

    init {
        super.window.bounds = Rectangle(400, 300, 300, 100)

        super.ok.addActionListener { e ->
            if (e?.source === super.ok) {
                when (Database.specialityRepository.remove(Either.Left(super.texts[0].text))) {
                    None -> failureMessage()
                    is Some -> successMessage("Speciality removed")
                }

                super.window.isVisible = false
            }
        }

        text = "Remove Speciality"
    }
}