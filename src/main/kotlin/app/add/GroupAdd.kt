package app.add

import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some

internal class GroupAdd : AbstractAdd(
    "Add Group",
    "Title"
) {
    init {
        text = "Add Group"

        super.ok.addActionListener { e ->
            if (e?.source === super.ok) {
                when (
                    Database.groupRepository.add(
                        Either.Right(Database.groupRepository.nextId()),
                        Either.Left(super.texts[0].text)
                    )
                ) {
                    None -> failureMessage()
                    is Some -> successMessage("Group added")
                }
            }
        }
    }
}