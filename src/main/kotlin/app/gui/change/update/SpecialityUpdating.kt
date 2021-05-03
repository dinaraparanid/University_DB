package app.gui.change.update

import app.gui.change.selector.SpecialitySelector
import app.core.Database

internal class SpecialityUpdating : AbstractUpdating(
    "Update Speciality",
    SpecialitySelector(),
    Database.specialityRepository::update,
    "Speciality updated",
    "Title"
)