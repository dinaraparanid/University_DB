package app.gui.change.add

import app.failureMessage
import app.gui.change.ChangeWindow
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Option

internal abstract class AbstractAdding(
    title: String,
    nextId: Int,
    addFunc: (Array<out Either<String, Int>?>) -> Option<Unit>,
    successMessage: String,
    vararg args: String
) : ChangeWindow(title, *args) {
    init {
        ok.addActionListener { e ->
            if (e?.source === ok) {
                when (
                    addFunc(
                        mutableListOf<Either<String, Int>>(Either.Right(nextId))
                            .apply { addAll(texts.map { Either.Left(it.text) }) }
                            .toTypedArray()
                    )
                ) {
                    None -> failureMessage()
                    else -> successMessage(successMessage)
                }

                window.isVisible = false
            }
        }
    }
}