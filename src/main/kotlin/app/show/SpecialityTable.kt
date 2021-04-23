package app.show

import app.core.Database
import app.core.speciality.Speciality

internal class SpecialityTable : ContentTable<Speciality>(
    "Specialities",
    { Database.specialityRepository.all() },
    "Title"
) { init { text = "Specialities" } }