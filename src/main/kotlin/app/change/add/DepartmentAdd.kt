package app.change.add

import app.change.ChangeWindow
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.awt.Rectangle

internal class DepartmentAdd : ChangeWindow(
    "Add Department",
    "Title"
) {

    init {
        super.window.bounds = Rectangle(400, 300, 300, 100)

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

                super.window.isVisible = false
            }
        }

        text = "Add Department"
    }
}