package app.gui.change.remove

import app.gui.change.selector.SpecialitySelector
import app.core.Database
import app.core.speciality.Speciality

internal class SpecialityRemoving : AbstractRemoving<Speciality>(
    SpecialitySelector(),
    Database.specialityRepository::remove,
    "Speciality removed"
)