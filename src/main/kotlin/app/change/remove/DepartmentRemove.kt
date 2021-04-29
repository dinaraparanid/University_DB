package app.change.remove

import app.change.selector.DepartmentSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import javax.swing.JMenuItem

internal class DepartmentRemove : JMenuItem() {
    private val ds = DepartmentSelector().apply {
        addSelectionListener { selectedId ->
            Database.departmentRepository.remove(selectedId).let { res ->
                when (res) {
                    None -> failureMessage()
                    is Some -> successMessage("Department removed")
                }
            }
        }
    }

    init {
        addActionListener {
            ds.window.isVisible = true
        }

        text = "Remove Department"
    }
}