package app

import app.show.*
import app.change.add.*
import app.change.remove.*
import app.change.update.*
import java.awt.*
import javax.swing.*

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
    }


    private val removeMenu = JMenu("Remove").apply {
        add(StudentRemove())
        add(GroupRemove())
        add(SpecialityRemove())
        add(TeacherRemove())
        add(SubjectRemove())
        add(DepartmentRemove())
        add(FacultyRemove())
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