package app.gui.change.marks

import app.core.Database
import app.core.date.Date
import app.failureMessage
import app.gui.change.ChangeWindow
import app.gui.change.selector.StudentSelector
import app.gui.change.selector.SubjectSelector
import app.successMessage
import arrow.core.Either
import arrow.core.None
import java.awt.Rectangle
import java.lang.Exception

internal class MarkAdding : ChangeWindow("Add Mark", "Mark") {
    private val subjectSelector = SubjectSelector()

    private val studentSelector = StudentSelector().also { ss ->
        ss.addSelectionListener { studentId ->
            ss.window.isVisible = false
            subjectSelector.window.isVisible = true

            subjectSelector.also { ss ->
                ss.addSelectionListener { subjectId ->
                    ss.window.isVisible = false

                    window.bounds = Rectangle(400, 300, 300, 100)
                    window.isVisible = true

                    ok.addActionListener { e ->
                        if (e?.source === ok) {
                            try {
                                when (
                                    Database.markRepository.add(
                                        Either.Right(Database.markRepository.nextId()),
                                        Either.Right(texts.first().text.trim().toInt()),
                                        Either.Right(studentId),
                                        Either.Right(subjectId),
                                        Either.Left(Date().toString())
                                    )
                                ) {
                                    None -> failureMessage()
                                    else -> successMessage("Mark added")
                                }

                                window.isVisible = false
                            } catch (e: Exception) {
                                failureMessage("Mark input error")
                            }
                        }
                    }
                }
            }
        }
    }

    override fun show() {
        studentSelector.window.isVisible = true
    }
}