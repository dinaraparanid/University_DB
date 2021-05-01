package app.gui.change.update

import app.gui.change.ChangeWindow
import app.gui.change.selector.AbstractSelector
import app.core.polymorphism.Entity
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Option
import java.awt.Rectangle

internal abstract class AbstractUpdate<T : Entity>(
    title: String,
    selector: AbstractSelector<T>,
    updateFunc: (Array<out Either<String, Int>?>) -> Option<Unit>,
    vararg args: String
) : ChangeWindow(title, *args) {
    init {
        action = null
        window.isVisible = false
        text = title

        this.addActionListener {
            selector.window.isVisible = true

            selector.addSelectionListener { selectedId ->
                selector.window.isVisible = false
                window.bounds = Rectangle(400, 300, 300, 100)
                window.isVisible = true

                ok.addActionListener {
                    updateFunc(
                        texts
                            .map {
                                val x: Either<String, Int> = Either.Left(it.text)
                                x
                            }
                            .toMutableList()
                            .apply { add(Either.Right(selectedId)) }
                            .toTypedArray(),
                    ).let { res ->
                        when (res) {
                            None -> failureMessage()
                            else -> successMessage("${title.trim().split(' ').last()} updated")
                        }

                        window.isVisible = false
                    }
                }
            }
        }
    }
}