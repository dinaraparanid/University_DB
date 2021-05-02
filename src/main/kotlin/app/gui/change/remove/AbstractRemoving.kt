package app.gui.change.remove

import app.gui.change.selector.AbstractSelector
import app.core.polymorphism.Entity
import app.core.polymorphism.Showable
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Option

internal abstract class AbstractRemoving<F : Entity>(
    s: AbstractSelector<F>,
    removeFunc: (Int) -> Option<Unit>,
    successMessage: String
) : Showable {
    private val selector = s.apply {
        addSelectionListener { selectedId ->
            when (removeFunc(selectedId)) {
                None -> failureMessage()
                else -> successMessage(successMessage)
            }
        }
    }

    override fun show() {
        selector.window.isVisible = true
    }
}