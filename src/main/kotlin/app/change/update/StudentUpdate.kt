package app.change.update

import app.change.ChangeWindow
import app.change.selector.StudentSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

internal class StudentUpdate :
    ChangeWindow(
        "Update Student",
        "First Name",
        "Second Name",
        "Middle Name",
        "Group Title",
        "Info"
    ) {
    init {
        window.isVisible = false

        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                if (e?.source === this) {
                    StudentSelector().apply { show() }.apply { show() }.selectedId.takeIf { it is Some }?.let { id ->
                        window.isVisible = true

                        ok.addActionListener { e ->
                            if (e?.source === ok) {
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
                                    id.toEither { String() }
                                ).let { res ->
                                    when (res) {
                                        None -> failureMessage()
                                        is Some -> successMessage("Student updated")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        text = "Update Student"
    }
}