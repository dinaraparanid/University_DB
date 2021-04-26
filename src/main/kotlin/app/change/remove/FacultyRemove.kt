package app.change.remove

import app.change.selector.FacultySelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import java.awt.event.ActionEvent
import javax.swing.AbstractAction
import javax.swing.JMenuItem

internal class FacultyRemove : JMenuItem() {
    init {
        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                if (e?.source === this) {
                    FacultySelector().apply { show() }.selectedId.takeIf { it is Some }?.let {
                        Database.facultyRepository.remove(it.orNull()!!).let { res ->
                            when (res) {
                                None -> failureMessage()
                                is Some -> successMessage("Faculty removed")
                            }
                        }
                    }
                }
            }
        }

        text = "Remove Faculty"
    }
}