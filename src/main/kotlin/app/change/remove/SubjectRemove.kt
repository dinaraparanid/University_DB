package app.change.remove

import app.change.selector.SubjectSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import javax.swing.JMenuItem

internal class SubjectRemove : JMenuItem() {
    private val ss = SubjectSelector().apply {
        addSelectionListener { selectedId ->
            Database.subjectRepository.remove(selectedId).let { res ->
                when (res) {
                    None -> failureMessage()
                    is Some -> successMessage("Subject removed")
                }
            }

            window.isVisible = false
        }
    }

    init {
        addActionListener {
            ss.window.isVisible = true
        }

        text = "Remove Subject"
    }
}