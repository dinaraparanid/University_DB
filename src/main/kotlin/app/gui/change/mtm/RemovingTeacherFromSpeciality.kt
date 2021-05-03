package app.gui.change.mtm

import app.gui.change.selector.SpecialitySelector
import app.gui.change.selector.TeacherSelector
import app.core.Database

internal class RemovingTeacherFromSpeciality : AbstractMTM(
    SpecialitySelector(),
    TeacherSelector(),
    Database.specialityRepository::removeTeacher,
    "Teacher removed from Speciality"
)