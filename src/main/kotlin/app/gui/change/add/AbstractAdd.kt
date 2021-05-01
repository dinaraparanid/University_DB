package app.gui.change.add

import app.failureMessage
import app.gui.change.ChangeWindow
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Option
import java.awt.Rectangle

internal abstract class AbstractAdd(
    title: String,
    nextId: Int,
    addFunc: (Array<out Either<String, Int>?>) -> Option<Unit>,
    successMessage: String,
    vararg args: String
) : ChangeWindow(title, *args) {
    init {
        super.window.bounds = Rectangle(400, 300, 300, 100)

        super.ok.addActionListener { e ->
            if (e?.source === super.ok) {
                when (
                    addFunc(
                        mutableListOf<Either<String, Int>>(Either.Right(nextId))
                            .apply { addAll(super.texts.map { Either.Left(it.text) }) }
                            .toTypedArray()
                    )
                ) {
                    None -> failureMessage()
                    else -> successMessage(successMessage)
                }

                super.window.isVisible = false
            }
        }

        text = title
    }
}