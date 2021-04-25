package app.change.remove

import app.change.ChangeWindow
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.awt.Rectangle

internal class StudentRemove : ChangeWindow(
    "Remove Student",
    "First Name",
    "Second Name",
    "Middle Name",
    "Group Title"
) {

    init {
        super.window.bounds = Rectangle(400, 300, 300, 100)

        super.ok.addActionListener { e ->
            if (e?.source === super.ok) {
                when (
                    Database.studentRepository.remove(
                        Either.Left(super.texts[0].text),
                        Either.Left(super.texts[1].text),
                        Either.Left(super.texts[2].text),
                        Database.groupRepository.getIdByTitle(super.texts[3].text).let {
                            when (it) {
                                None -> null
                                is Some -> Either.Right(it.value)
                            }
                        }
                    )
                ) {
                    None -> failureMessage()
                    is Some -> successMessage("Student removed")
                }

                super.window.isVisible = false
            }
        }

        text = "Remove Student"
    }
}