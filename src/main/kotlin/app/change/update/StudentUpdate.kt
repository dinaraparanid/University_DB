package app.change.update

import app.change.ChangeWindow
import app.change.selector.StudentSelector
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

internal class StudentUpdate :
    ChangeWindow(
        "Update Student",
        "First Name",
        "Second Name",
        "Middle Name",
        "Group Title",
        "Info"
    ) {
    private val ss = StudentSelector()

    private val selectWindow = JFrame(ss.title)
        .apply {
            bounds = Rectangle(400, 300, 300, 400)
            contentPane.add(
                JScrollPane(ss.table.table),
                BorderLayout.CENTER
            )
        }

    init {
        window.isVisible = false

        addActionListener {
            selectWindow.isVisible = true

            GlobalScope.launch {
                while (selectWindow.isVisible) {
                    if (ss.selectedId is Some) {
                        ss.selectedId.takeIf { it is Some }?.let { id ->
                            selectWindow.isVisible = false
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