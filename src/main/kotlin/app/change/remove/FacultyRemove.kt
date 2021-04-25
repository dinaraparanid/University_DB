package app.change.remove

import app.change.selector.FacultySelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import javax.swing.JMenuItem

internal class FacultyRemove : JMenuItem("Remove Faculty") {
    init {
        FacultySelector().getSelectedId().takeIf { it is Some }?.let {
            Database.facultyRepository.remove(it.orNull()!!).let { res ->
                when (res) {
                    None -> failureMessage()
                    is Some -> successMessage("Faculty removed")
                }
            }
        }
    }
}