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
        add(Caller("Students") { StudentTable().show() })
        add(Caller("Groups") { GroupTable().show() })
        add(Caller("Specialities") { SpecialityTable().show() })
        add(Caller("Teachers") { SpecialityTable().show() })
        add(Caller("Subjects") { SubjectTable().show() })
        add(Caller("Departments") { DepartmentTable().show() })
        add(Caller("Faculties") { FacultyTable().show() })
        add(Caller("Marks of Student") { MarkTable().show() })
    }

    private val addMenu = JMenu("Add").apply {
        add(Caller("Add Student") { StudentAdding().show() })
        add(Caller("Add Group") { GroupAdding().show() })
        add(Caller("Add Speciality") { SpecialityAdding().show() })
        add(Caller("Add Teacher") { TeacherAdding().show() })
        add(Caller("Add Subject") { SubjectAdding().show() })
        add(Caller("Add Department") { DepartmentAdding().show() })
        add(Caller("Add Faculty") { FacultyAdding().show() })
        add(Caller("Add Mark to Student") { MarkAdding().show() })
        add(Caller("Add Subject to Department") { AddingSubjectToDepartment().show() })
        add(Caller("Add Subject to Teacher") { AddingSubjectToTeacher().show() })
        add(Caller("Add Teacher to Speciality") { AddingTeacherToSpeciality().show() })
    }

    private val removeMenu = JMenu("Remove").apply {
        add(Caller("Remove Student") { StudentRemoving().show() })
        add(Caller("Remove Group") { GroupRemoving().show() })
        add(Caller("Remove Speciality") { SpecialityRemoving().show() })
        add(Caller("Remove Teacher") { TeacherRemoving().show() })
        add(Caller("Remove Subject") { SubjectRemoving().show() })
        add(Caller("Remove Department") { DepartmentRemoving().show() })
        add(Caller("Remove Faculty") { FacultyRemoving().show() })
        add(Caller("Remove Mark from Student") { RemovingSubjectFromDepartment().show() })
        add(Caller("Remove Subject from Department") { RemovingSubjectFromTeacher().show() })
        add(Caller("Remove Subject from Teacher") { RemovingTeacherFromSpeciality().show() })
        add(Caller("Remove Teacher from Speciality") { MarkRemoving().show() })
    }

    private val updateMenu = JMenu("Update").apply {
        add(Caller("Update Student") { StudentUpdating().show() })
        add(Caller("Update Group") { GroupUpdating().show() })
        add(Caller("Update Speciality") { SpecialityUpdating().show() })
        add(Caller("Update Teacher") { TeacherUpdating().show() })
        add(Caller("Update Subject") { SubjectUpdating().show() })
        add(Caller("Update Department") { DepartmentUpdating().show() })
        add(Caller("Update Faculty") { FacultyUpdating().show() })
        add(Caller("Update Mark of Student") { MarkUpdating().show() })
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

    fun start() { frame.isVisible = true }
}