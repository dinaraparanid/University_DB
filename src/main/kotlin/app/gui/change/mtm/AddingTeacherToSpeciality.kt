package app.gui.change.mtm

import app.gui.change.selector.SpecialitySelector
import app.gui.change.selector.TeacherSelector
import app.core.Database
import app.core.speciality.Speciality
import app.core.teacher.Teacher

internal class AddingTeacherToSpeciality : AbstractMTM<Speciality, Teacher>(
    "Add Teacher to Speciality",
    SpecialitySelector(),
    TeacherSelector(),
    Database.specialityRepository::addTeacher,
    "Teacher added to Speciality"
)