package app.change.remove

import app.change.selector.SpecialitySelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import javax.swing.JMenuItem

internal class SpecialityRemove : JMenuItem("Remove Speciality") {
    init {
        SpecialitySelector().getSelectedId().takeIf { it is Some }?.let {
            Database.specialityRepository.remove(it.orNull()!!).let { res ->
                when (res) {
                    None -> failureMessage()
                    is Some -> successMessage("Speciality removed")
                }
            }
        }
    }
}