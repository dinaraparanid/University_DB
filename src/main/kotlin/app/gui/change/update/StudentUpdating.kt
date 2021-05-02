package app.gui.change.update

import app.gui.change.ChangeWindow
import app.gui.change.selector.StudentSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some

internal class StudentUpdating :
    ChangeWindow(
        "Update Student",
        "First Name",
        "Second Name",
        "Middle Name",
        "Group Title",
        "Information"
    ) {
    private val ss = StudentSelector().also { ss ->
        ss.addSelectionListener { selectedId ->
            ss.window.isVisible = false
            window.isVisible = true

            ok.addActionListener {
                Database.studentRepository.update(
                    Either.Left(texts[0].text),
                    Either.Left(texts[1].text),
                    Either.Left(texts[2].text),
                    Database.groupRepository.getIdByTitle(texts[3].text).let {
                        when (it) {
                            None -> null
                            is Some -> Either.Right(it.value)
                        }
                    },
                    Either.Left(texts[4].text),
                    Some(selectedId).toEither { String() }
                ).let { res ->
                    when (res) {
                        None -> failureMessage()
                        is Some -> successMessage("Student updated")
                    }

                    window.isVisible = false
                }
            }
        }
    }

    override fun show() {
        ss.window.isVisible = true
    }
}