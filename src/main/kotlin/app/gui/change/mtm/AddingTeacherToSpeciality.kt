package app.gui.change.mtm

import app.gui.change.selector.SpecialitySelector
import app.gui.change.selector.TeacherSelector
import app.core.Database

internal class AddingTeacherToSpeciality : AbstractMTM(
    SpecialitySelector(),
    TeacherSelector(),
    Database.specialityRepository::addTeacher,
    "Teacher added to Speciality"
)