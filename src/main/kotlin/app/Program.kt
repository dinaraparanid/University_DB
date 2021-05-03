package app

import app.gui.show.*
import app.gui.change.add.*
import app.gui.change.marks.*
import app.gui.change.mtm.*
import app.gui.change.remove.*
import app.gui.change.update.*
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuBar

/** Program itself */

object Program {
    private val showMenu = JMenu("Show").apply {
        add(Caller("Students", StudentTable()))
        add(Caller("Groups", GroupTable()))
        add(Caller("Specialities", SpecialityTable()))
        add(Caller("Teachers", SpecialityTable()))
        add(Caller("Subjects", SubjectTable()))
        add(Caller("Departments", DepartmentTable()))
        add(Caller("Faculties", FacultyTable()))
        add(Caller("Marks of Student", MarkTable()))
    }

    private val addMenu = JMenu("Add").apply {
        add(Caller("Add Student", StudentAdding()))
        add(Caller("Add Group", GroupAdding()))
        add(Caller("Add Speciality", SpecialityAdding()))
        add(Caller("Add Teacher", TeacherAdding()))
        add(Caller("Add Subject", SubjectAdding()))
        add(Caller("Add Department", DepartmentAdding()))
        add(Caller("Add Faculty", FacultyAdding()))
        add(Caller("Add Mark to Student", MarkAdding()))
        add(Caller("Add Subject to Department", AddingSubjectToDepartment()))
        add(Caller("Add Subject to Teacher", AddingSubjectToTeacher()))
        add(Caller("Add Teacher to Speciality", AddingTeacherToSpeciality()))
    }

    private val removeMenu = JMenu("Remove").apply {
        add(Caller("Remove Student", StudentRemoving()))
        add(Caller("Remove Group", GroupRemoving()))
        add(Caller("Remove Speciality", SpecialityRemoving()))
        add(Caller("Remove Teacher", TeacherRemoving()))
        add(Caller("Remove Subject", SubjectRemoving()))
        add(Caller("Remove Department", DepartmentRemoving()))
        add(Caller("Remove Faculty", FacultyRemoving()))
        add(Caller("Remove Mark from Student", RemovingSubjectFromDepartment()))
        add(Caller("Remove Subject from Department", RemovingSubjectFromTeacher()))
        add(Caller("Remove Subject from Teacher", RemovingTeacherFromSpeciality()))
        add(Caller("Remove Teacher from Speciality", MarkRemoving()))
    }

    private val updateMenu = JMenu("Update").apply {
        add(Caller("Update Student", StudentUpdating()))
        add(Caller("Update Group", GroupUpdating()))
        add(Caller("Update Speciality", SpecialityUpdating()))
        add(Caller("Update Teacher", TeacherUpdating()))
        add(Caller("Update Subject", SubjectUpdating()))
        add(Caller("Update Department", DepartmentUpdating()))
        add(Caller("Update Faculty", FacultyUpdating()))
        add(Caller("Update Mark of Student", MarkUpdating()))
    }

    private val frame = JFrame("University Database").also { frame ->
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.bounds = Rectangle(600, 300, 800, 500)

        frame.contentPane.add(
            JMenuBar().apply {
                add(showMenu)
                add(addMenu)
                add(removeMenu)
                add(updateMenu)
            },
            BorderLayout.NORTH
        )
    }

    /** Start of whole program */

    fun start() {
        frame.isVisible = true
    }
}