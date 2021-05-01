package app.gui.change.mtm

import app.gui.change.selector.AbstractSelector
import app.core.polymorphism.Entity
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Option
import javax.swing.JMenuItem

internal abstract class AbstractMTM<F : Entity, S : Entity>(
    title: String,
    s1: AbstractSelector<F>,
    s2: AbstractSelector<S>,
    func: (Int, Int) -> Option<Unit>,
    successMessage: String
) : JMenuItem() {
    private val selector2 = s2

    private val selector1 = s1.also { selector1 ->
        selector1.addSelectionListener { selectedId1 ->
            selector1.window.isVisible = false
            
            selector2.addSelectionListener { selectedId2 ->  
                when (func(selectedId1, selectedId2)) {
                    None -> failureMessage()
                    else -> successMessage(successMessage)
                }

                selector2.window.isVisible = false
            }
        }
    }

    init {
        this.addActionListener {
            selector1.window.isVisible = true
        }

        text = title
    }
}