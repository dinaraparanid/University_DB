package app.change.selector

import app.core.speciality.Speciality
import app.show.SpecialityTable

internal class SpecialitySelector : AbstractSelector<Speciality>(
    "Select Speciality",
    SpecialityTable()
)