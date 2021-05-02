package app.gui.change.marks

import app.core.date.Date
import app.failureMessage
import app.gui.change.ChangeWindow
import app.gui.change.selector.StudentSelector
import app.gui.change.selector.SubjectSelector
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Option
import java.awt.Rectangle

internal abstract class AbstractChange(
    title: String,
    func: (Array<out Either<String, Int>?>) -> Option<Unit>,
    successMessage: String
) : ChangeWindow(title, "Mark") {
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
                                    func(
                                        arrayOf(
                                            Either.Right(studentId),
                                            Either.Right(subjectId),
                                            Either.Left(
                                                Date(
                                                    texts[0].text.trim().toInt(),
                                                    texts[1].text.trim().toInt(),
                                                    texts[2].text.trim().toInt()
                                                ).toString()
                                            )
                                        )
                                    )
                                ) {
                                    None -> failureMessage()
                                    else -> successMessage(successMessage)
                                }

                                window.isVisible = false
                            } catch (e: Exception) {
                                failureMessage("Date input error")
                            }
                        }
                    }
                }
            }
        }
    }

    init {
        action = null
        window.isVisible = false

        this.addActionListener {
            studentSelector.window.isVisible = true
        }

        text = title
    }
}