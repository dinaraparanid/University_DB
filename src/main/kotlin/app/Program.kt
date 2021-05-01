package app

import app.gui.show.*
import app.gui.change.add.*
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
    }

    private val addMenu = JMenu("Add").apply {
        add(StudentAdd())
        add(GroupAdd())
        add(SpecialityAdd())
        add(TeacherAdd())
        add(SubjectAdd())
        add(DepartmentAdd())
        add(FacultyAdd())
        add(AddingSubjectToDepartment())
        add(AddingSubjectToTeacher())
        add(AddingTeacherToSpeciality())
    }

    private val removeMenu = JMenu("Remove").apply {
        add(StudentRemove())
        add(GroupRemove())
        add(SpecialityRemove())
        add(TeacherRemove())
        add(SubjectRemove())
        add(DepartmentRemove())
        add(FacultyRemove())
        add(RemovingSubjectFromDepartment())
        add(RemovingSubjectFromTeacher())
        add(RemovingTeacherFromSpeciality())
    }

    private val updateMenu = JMenu("Update").apply {
        add(StudentUpdate())
        add(GroupUpdate())
        add(SpecialityUpdate())
        add(TeacherUpdate())
        add(SubjectUpdate())
        add(DepartmentUpdate())
        add(FacultyUpdate())
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