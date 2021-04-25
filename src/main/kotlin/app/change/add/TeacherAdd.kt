package app.change.add

import app.change.ChangeWindow
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.awt.Rectangle

internal class TeacherAdd : ChangeWindow(
    "Add Teacher",
    "First Name",
    "Second Name",
    "Middle Name",
    "Information"
) {
    init {
        text = "Add Teacher"

        super.window.bounds = Rectangle(400, 300, 300, 200)

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

                super.window.isVisible = false
            }
        }
    }
}