package app.change.update

import app.change.ChangeWindow
import app.change.selector.TeacherSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some

internal class TeacherUpdate :
    ChangeWindow(
        "Update Teacher",
        "First Name",
        "Second Name",
        "Middle Name",
        "Info"
    ) {
    private val ts = TeacherSelector().also { ts ->
        ts.addSelectionListener { selectedId ->
            ts.window.isVisible = false
            window.isVisible = true

            ok.addActionListener {
                Database.teacherRepository.update(
                    Either.Left(texts[0].text),
                    Either.Left(texts[1].text),
                    Either.Left(texts[2].text),
                    Either.Left(texts[3].text),
                    Some(selectedId).toEither { String() }
                ).let { res ->
                    when (res) {
                        None -> failureMessage()
                        is Some -> successMessage("Teacher updated")
                    }

                    window.isVisible = false
                }
            }
        }
    }

    init {
        window.isVisible = false

        addActionListener {
            ts.window.isVisible = true
        }

        text = "Update Teacher"
    }
}