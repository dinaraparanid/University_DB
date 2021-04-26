package app.change.remove

import app.change.ChangeWindow
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.awt.Rectangle

internal class GroupRemove : ChangeWindow(
    "Remove Group",
    "Group Title",
    "Speciality Title"
) {
    init {
        super.window.bounds = Rectangle(400, 300, 300, 200)

        super.ok.addActionListener { e ->
            if (e?.source === super.ok) {
                when (
                    Database.groupRepository.remove(
                        Either.Left(super.texts[0].text),
                        Database.specialityRepository.getIdByTitle(super.texts[1].text).let {
                            when (it) {
                                None -> null
                                is Some -> Either.Right(it.value)
                            }
                        }

                    )
                ) {
                    None -> failureMessage()
                    is Some -> successMessage("Group removed")
                }

                super.window.isVisible = false
            }
        }

        text = "Remove Group"
    }
}