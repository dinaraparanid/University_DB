package app.change.update

import app.change.ChangeWindow
import app.change.selector.DepartmentSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.JFrame
import javax.swing.JScrollPane

internal class DepartmentUpdate : ChangeWindow("Update Department", "Title", "Faculty title") {
    private val ds = DepartmentSelector()

    private val selectWindow = JFrame(ds.title)
        .apply {
            bounds = Rectangle(400, 300, 300, 400)
            contentPane.add(
                JScrollPane(ds.table.table),
                BorderLayout.CENTER
            )
        }

    init {
        window.isVisible = false

        addActionListener {
            selectWindow.isVisible = true

            GlobalScope.launch {
                while (selectWindow.isVisible) {
                    if (ds.selectedId is Some) {
                        ds.selectedId.takeIf { it is Some }?.let { id ->
                            selectWindow.isVisible = false
                            window.isVisible = true

                            ok.addActionListener {
                                Database.departmentRepository.update(
                                    Either.Left(texts[0].text),
                                    Database.facultyRepository.getIdByTitle(texts[1].text).let {
                                        when (it) {
                                            None -> null
                                            is Some -> Either.Right(it.value)
                                        }
                                    },
                                    id.toEither { String() }
                                ).let { res ->
                                    when (res) {
                                        None -> failureMessage()
                                        is Some -> successMessage("Department updated")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        text = "Update Department"
    }
}