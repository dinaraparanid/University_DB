package app.add

import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some

internal class DepartmentAdd : AbstractAdd(
    "Add Department",
    "Title"
) {

    init {
        super.ok.addActionListener { e ->
            if (e?.source === super.ok) {
                when (
                    Database.departmentRepository.add(
                        Either.Right(Database.departmentRepository.nextId()),
                        Either.Left(super.texts[0].text),
                    )
                ) {
                    None -> failureMessage()
                    is Some -> successMessage("Department added")
                }
            }
        }

        text = "Add Department"
    }
}