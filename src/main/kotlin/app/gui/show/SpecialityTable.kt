package app.gui.show

import app.core.Database
import app.core.speciality.Speciality

internal class SpecialityTable : AbstractTable<Speciality>(
    "Specialities",
    Database.specialityRepository::all,
    "Title"
) { init { text = "Specialities" } }