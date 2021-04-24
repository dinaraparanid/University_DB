package app.add

import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some

internal class SubjectAdd : AbstractAdd(
    "Add Subject",
    "Title"
) {
    init {
        text = "Add Subject"

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
            }
        }
    }
}