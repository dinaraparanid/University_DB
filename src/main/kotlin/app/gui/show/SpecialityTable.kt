package app.gui.show

import app.core.Database

internal class SpecialityTable : AbstractTable(
    "Specialities",
    Database.specialityRepository::all,
    "Title"
)