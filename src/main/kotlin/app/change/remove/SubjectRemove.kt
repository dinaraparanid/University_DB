package app.change.remove

import app.change.selector.SubjectSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import javax.swing.JMenuItem

internal class SubjectRemove : JMenuItem("Remove Subject") {
    init {
        SubjectSelector().getSelectedId().takeIf { it is Some }?.let {
            Database.subjectRepository.remove(it.orNull()!!).let { res ->
                when (res) {
                    None -> failureMessage()
                    is Some -> successMessage("Subject removed")
                }
            }
        }
    }
}