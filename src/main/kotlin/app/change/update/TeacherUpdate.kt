package app.change.update

import app.change.ChangeWindow
import app.change.selector.TeacherSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

internal class TeacherUpdate :
    ChangeWindow(
        "Update Teacher",
        "First Name",
        "Second Name",
        "Middle Name",
        "Info"
    ) {
    init {
        window.isVisible = false

        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                if (e?.source === this) {
                    TeacherSelector().apply { show() }.selectedId.takeIf { it is Some }?.let { id ->
                        window.isVisible = true

                        ok.addActionListener { e ->
                            if (e?.source === ok) {
                                Database.teacherRepository.update(
                                    Either.Left(texts[0].text),
                                    Either.Left(texts[1].text),
                                    Either.Left(texts[2].text),
                                    Either.Left(texts[4].text),
                                    id.toEither { String() }
                                ).let { res ->
                                    when (res) {
                                        None -> failureMessage()
                                        is Some -> successMessage("teacher updated")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        text = "Update Teacher"
    }
}