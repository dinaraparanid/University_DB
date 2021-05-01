package app.gui.change.selector

import app.core.speciality.Speciality
import app.gui.show.SpecialityTable

internal class SpecialitySelector : AbstractSelector<Speciality>(
    "Select Speciality",
    SpecialityTable()
)