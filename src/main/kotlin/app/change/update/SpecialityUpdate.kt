package app.change.update

import app.change.selector.SpecialitySelector
import app.core.Database
import app.core.speciality.Speciality

internal class SpecialityUpdate : AbstractUpdateTitle<Speciality>(
    "Update Speciality",
    SpecialitySelector(),
    Database.specialityRepository
) { init { text = "Update Speciality" } }