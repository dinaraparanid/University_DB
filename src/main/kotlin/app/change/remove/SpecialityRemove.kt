package app.change.remove

import app.change.selector.SpecialitySelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.None
import arrow.core.Some
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.JFrame
import javax.swing.JMenuItem
import javax.swing.JScrollPane

internal class SpecialityRemove : JMenuItem() {

    private val ss = SpecialitySelector()

    private val window = JFrame(ss.title)
        .apply {
            bounds = Rectangle(400, 300, 300, 400)
            contentPane.add(
                JScrollPane(ss.table.table),
                BorderLayout.CENTER
            )
        }

    init {
        addActionListener {
            window.isVisible = true

            GlobalScope.launch {
                while (window.isVisible) {
                    if (ss.selectedId is Some) {
                        Database.specialityRepository.remove(ss.selectedId!!.orNull()!!).let { res ->
                            when (res) {
                                None -> failureMessage()
                                is Some -> successMessage("Speciality removed")
                            }
                        }

                        window.isVisible = false
                        break
                    }
                }
            }
        }

        text = "Remove Speciality"
    }
}