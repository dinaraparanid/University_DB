package app.change.remove

import app.change.selector.DepartmentSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import javax.swing.JMenuItem

internal class DepartmentRemove : JMenuItem("Remove Department") {
    init {
        DepartmentSelector().getSelectedId().takeIf { it is Some }?.let {
            Database.departmentRepository.remove(it.orNull()!!).let { res ->
                when (res) {
                    None -> failureMessage()
                    is Some -> successMessage("Department removed")
                }
            }
        }
    }
}