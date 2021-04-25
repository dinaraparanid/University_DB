package app.change.add

import app.change.ChangeWindow
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.awt.Rectangle

internal class SubjectAdd : ChangeWindow(
    "Add Subject",
    "Title"
) {
    init {
        text = "Add Subject"

        super.window.bounds = Rectangle(400, 300, 300, 100)

        super.ok.addActionListener { e ->
            if (e?.source === super.ok) {
                when (
                    Database.subjectRepository.add(
                        Either.Right(Database.subjectRepository.nextId()),
                        Either.Left(super.texts[0].text)
                    )
                ) {
                    None -> failureMessage()
                    is Some -> successMessage("Subject added")
                }

                super.window.isVisible = false
            }
        }
    }
}