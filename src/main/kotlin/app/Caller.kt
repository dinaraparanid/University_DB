package app

import java.awt.event.ActionEvent
import javax.swing.AbstractAction

internal class Caller(title: String, private val callable: () -> Any) : AbstractAction(title) {
    override fun actionPerformed(e: ActionEvent?) {
        callable()
    }
}