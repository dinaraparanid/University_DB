package app

import app.core.polymorphism.Showable
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

internal class Caller(title: String, private val callable: Showable) : AbstractAction(title) {
    override fun actionPerformed(e: ActionEvent?) {
        callable.show()
    }
}