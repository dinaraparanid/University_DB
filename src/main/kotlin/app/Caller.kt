package app

import java.awt.event.ActionEvent
import javax.swing.AbstractAction

internal class Caller(title: String, private val call: () -> Unit) : AbstractAction(title) {
    override fun actionPerformed(e: ActionEvent?) {
        call()
    }
}