package app

import app.show.*
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

    private val addMenu = JMenu("Add")
    private val removeMenu = JMenu("Remove")
    private val updateMenu = JMenu("Update")

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