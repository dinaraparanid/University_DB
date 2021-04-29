package app.change.remove

import app.change.selector.TeacherSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import javax.swing.JMenuItem

internal class TeacherRemove : JMenuItem() {
    private val ts = TeacherSelector().apply {
        addSelectionListener { selectedId ->
            Database.teacherRepository.remove(selectedId).let { res ->
                when (res) {
                    None -> failureMessage()
                    is Some -> successMessage("Teacher removed")
                }
            }

            window.isVisible = false
        }
    }

    init {
        addActionListener {
            ts.window.isVisible = true
        }

        text = "Remove Teacher"
    }
}