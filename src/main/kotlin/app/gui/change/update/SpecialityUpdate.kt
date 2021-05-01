package app.gui.change.update

import app.gui.change.selector.SpecialitySelector
import app.core.Database
import app.core.speciality.Speciality

internal class SpecialityUpdate : AbstractUpdate<Speciality>(
    "Update Speciality",
    SpecialitySelector(),
    Database.specialityRepository::update,
    "Title"
) { init { text = "Update Speciality" } }