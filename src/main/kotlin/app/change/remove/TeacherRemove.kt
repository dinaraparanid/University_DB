package app.change.remove

import app.change.selector.TeacherSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import javax.swing.JMenuItem

internal class TeacherRemove : JMenuItem("Remove Teacher") {
    init {
        TeacherSelector().getSelectedId().takeIf { it is Some }?.let {
            Database.teacherRepository.remove(it.orNull()!!).let { res ->
                when (res) {
                    None -> failureMessage()
                    is Some -> successMessage("Teacher removed")
                }
            }
        }
    }
}