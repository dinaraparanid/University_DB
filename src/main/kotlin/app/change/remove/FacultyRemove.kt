package app.change.remove

import app.change.selector.FacultySelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import javax.swing.*

internal class FacultyRemove : JMenuItem() {
    private val fs = FacultySelector().apply {
        addSelectionListener { selectedId ->
            Database.facultyRepository.remove(selectedId).let { res ->
                when (res) {
                    None -> failureMessage()
                    is Some -> successMessage("Faculty removed")
                }
            }

            window.isVisible = false
        }
    }

    init {
        addActionListener {
            fs.window.isVisible = true
        }

        text = "Remove Faculty"
    }
}