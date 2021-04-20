package app.show

import app.Database
import app.speciality.Speciality

internal class SpecialityTable : ContentTable<Speciality>(
    "Specialities",
    { Database.specialityRepository.all() },
    "title"
)