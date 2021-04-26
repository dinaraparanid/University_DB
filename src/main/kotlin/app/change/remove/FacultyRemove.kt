package app.change.remove

import app.change.selector.FacultySelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.*

internal class FacultyRemove : JMenuItem() {
    private val fs = FacultySelector()

    private val window = JFrame(fs.title)
        .apply {
            bounds = Rectangle(400, 300, 300, 400)
            contentPane.add(
                JScrollPane(fs.table.table),
                BorderLayout.CENTER
            )
        }

    init {
        addActionListener {
            window.isVisible = true

            GlobalScope.launch {
                while (window.isVisible) {
                    if (fs.selectedId is Some) {
                        Database.facultyRepository.remove(fs.selectedId!!.orNull()!!).let { res ->
                            when (res) {
                                None -> failureMessage()
                                is Some -> successMessage("Faculty removed")
                            }
                        }

                        window.isVisible = false
                        break
                    }
                }
            }
        }

        text = "Remove Faculty"
    }
}