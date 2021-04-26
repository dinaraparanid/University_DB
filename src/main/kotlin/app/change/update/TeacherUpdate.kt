package app.change.update

import app.change.ChangeWindow
import app.change.selector.TeacherSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.JFrame
import javax.swing.JScrollPane

internal class TeacherUpdate :
    ChangeWindow(
        "Update Teacher",
        "First Name",
        "Second Name",
        "Middle Name",
        "Info"
    ) {
    private val ts = TeacherSelector()

    private val selectWindow = JFrame(ts.title)
        .apply {
            bounds = Rectangle(400, 300, 300, 400)
            contentPane.add(
                JScrollPane(ts.table.table),
                BorderLayout.CENTER
            )
        }

    init {
        window.isVisible = false

        addActionListener {
            selectWindow.isVisible = true

            GlobalScope.launch {
                while (selectWindow.isVisible) {
                    if (ts.selectedId is Some) {
                        ts.selectedId.takeIf { it is Some }?.let { id ->
                            selectWindow.isVisible = false
                            window.isVisible = true

                            ok.addActionListener {
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