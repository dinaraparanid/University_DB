package app.change.remove

import app.change.selector.SpecialitySelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import javax.swing.JMenuItem

internal class SpecialityRemove : JMenuItem() {

    private val ss = SpecialitySelector().apply {
        addSelectionListener { selectedId ->
            Database.specialityRepository.remove(selectedId).let { res ->
                when (res) {
                    None -> failureMessage()
                    is Some -> successMessage("Speciality removed")
                }
            }

            window.isVisible = false
        }
    }

    init {
        addActionListener {
            ss.window.isVisible = true
        }

        text = "Remove Speciality"
    }
}