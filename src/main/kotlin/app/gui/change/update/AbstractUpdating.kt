package app.gui.change.update

import app.gui.change.ChangeWindow
import app.gui.change.selector.AbstractSelector
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Option
import java.awt.Rectangle

internal abstract class AbstractUpdating(
    title: String,
    private val selector: AbstractSelector,
    updateFunc: (Array<out Either<String, Int>?>) -> Option<Unit>,
    successMessage: String,
    vararg args: String
) : ChangeWindow(title, *args) {
    init {
        selector.addSelectionListener { selectedId ->
            selector.window.isVisible = false
            window.bounds = Rectangle(400, 300, 300, 100)
            window.isVisible = true

            ok.addActionListener {
                when (
                    updateFunc(
                        texts
                            .map {
                                val x: Either<String, Int> = Either.Left(it.text)
                                x
                            }
                            .toMutableList()
                            .apply { add(Either.Right(selectedId)) }
                            .toTypedArray(),
                    )
                ) {
                    None -> failureMessage()
                    else -> successMessage(successMessage)
                }

                window.isVisible = false
            }
        }
    }

    override fun show() {
        selector.window.isVisible = true
    }
}