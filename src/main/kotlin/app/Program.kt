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
        add(StudentTable())
        add(GroupTable())
        add(SpecialityTable())
        add(TeacherTable())
        add(SubjectTable())
        add(DepartmentTable())
        add(FacultyTable())
        add(MarkTable())
    }

    private val addMenu = JMenu("Add").apply {
        add(StudentAdding())
        add(GroupAdding())
        add(SpecialityAdding())
        add(TeacherAdding())
        add(SubjectAdding())
        add(DepartmentAdding())
        add(FacultyAdding())
        add(AddingSubjectToDepartment())
        add(AddingSubjectToTeacher())
        add(AddingTeacherToSpeciality())
        add(MarkAdding())
    }

    private val removeMenu = JMenu("Remove").apply {
        add(StudentRemoving())
        add(GroupRemoving())
        add(SpecialityRemoving())
        add(TeacherRemoving())
        add(SubjectRemoving())
        add(DepartmentRemoving())
        add(FacultyRemoving())
        add(RemovingSubjectFromDepartment())
        add(RemovingSubjectFromTeacher())
        add(RemovingTeacherFromSpeciality())
        add(MarkRemoving())
    }

    private val updateMenu = JMenu("Update").apply {
        add(StudentUpdating())
        add(GroupUpdating())
        add(SpecialityUpdating())
        add(TeacherUpdating())
        add(SubjectUpdating())
        add(DepartmentUpdating())
        add(FacultyUpdating())
        add(MarkUpdating())
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