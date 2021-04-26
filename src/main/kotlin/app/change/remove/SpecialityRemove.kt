package app.change.remove

import app.change.selector.SpecialitySelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import java.awt.event.ActionEvent
import javax.swing.AbstractAction
import javax.swing.JMenuItem

internal class SpecialityRemove : JMenuItem() {
    init {
        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                if (e?.source === this) {
                    SpecialitySelector().apply { show() }.selectedId.takeIf { it is Some }?.let {
                        Database.specialityRepository.remove(it.orNull()!!).let { res ->
                            when (res) {
                                None -> failureMessage()
                                is Some -> successMessage("Speciality removed")
                            }
                        }
                    }
                }
            }
        }

        text = "Remove Speciality"
    }
}