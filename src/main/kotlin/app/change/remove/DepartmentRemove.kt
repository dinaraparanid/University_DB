package app.change.remove

import app.change.selector.DepartmentSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import java.awt.event.ActionEvent
import javax.swing.AbstractAction
import javax.swing.JMenuItem

internal class DepartmentRemove : JMenuItem() {
    init {
        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                if (e?.source === this) {
                    DepartmentSelector().apply { show() }.selectedId.takeIf { it is Some }?.let {
                        Database.departmentRepository.remove(it.orNull()!!).let { res ->
                            when (res) {
                                None -> failureMessage()
                                is Some -> successMessage("Department removed")
                            }
                        }
                    }
                }
            }
        }

        text = "Remove Department"
    }
}