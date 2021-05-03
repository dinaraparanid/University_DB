package app.gui.change.remove

import app.gui.change.selector.SpecialitySelector
import app.core.Database

internal class SpecialityRemoving : AbstractRemoving(
    SpecialitySelector(),
    Database.specialityRepository::remove,
    "Speciality removed"
)