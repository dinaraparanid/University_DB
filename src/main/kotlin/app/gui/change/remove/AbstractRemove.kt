package app.gui.change.remove

import app.gui.change.selector.AbstractSelector
import app.core.polymorphism.Entity
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Option
import javax.swing.JMenuItem

internal abstract class AbstractRemove<F : Entity>(
    title: String,
    s: AbstractSelector<F>,
    removeFunc: (Int) -> Option<Unit>,
    successMessage: String
) : JMenuItem() {
    private val selector = s.apply {
        addSelectionListener { selectedId ->
            when (removeFunc(selectedId)) {
                None -> failureMessage()
                else -> successMessage(successMessage)
            }
        }
    }

    init {
        this.addActionListener {
            selector.window.isVisible = true
        }

        text = title
    }
}