package app.gui.change.mtm

import app.gui.change.selector.AbstractSelector
import app.core.polymorphism.Showable
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Option

internal abstract class AbstractMTM(
    s1: AbstractSelector,
    s2: AbstractSelector,
    func: (Int, Int) -> Option<Unit>,
    successMessage: String
) : Showable {
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

    override fun show() {
        selector1.window.isVisible = true
    }
}