package app.gui.change.mtm

import app.gui.change.selector.SpecialitySelector
import app.gui.change.selector.TeacherSelector
import app.core.Database
import app.core.speciality.Speciality
import app.core.teacher.Teacher

internal class RemovingTeacherFromSpeciality : AbstractMTM<Speciality, Teacher>(
    SpecialitySelector(),
    TeacherSelector(),
    Database.specialityRepository::removeTeacher,
    "Teacher removed from Speciality"
)