package app.gui.change.update

import app.gui.change.ChangeWindow
import app.gui.change.selector.DepartmentSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some

internal class DepartmentUpdating : ChangeWindow("Update Department", "Title", "Faculty title") {
    private val ds = DepartmentSelector().also { ds ->
        ds.addSelectionListener { selectedId ->
            ds.window.isVisible = false
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
                    Some(selectedId).toEither { String() }
                ).let { res ->
                    when (res) {
                        None -> failureMessage()
                        else -> successMessage("Department updated")
                    }

                    window.isVisible = false
                }
            }
        }
    }

    override fun show() {
        ds.window.isVisible = true
    }
}