package app.gui.change.update

import app.gui.change.ChangeWindow
import app.gui.change.selector.GroupSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some

internal class GroupUpdating : ChangeWindow("Update Group", "Title", "Speciality title") {
    private val gs = GroupSelector().also { gs ->
        gs.addSelectionListener { selectedId ->
            gs.window.isVisible = false
            window.isVisible = true

            ok.addActionListener {
                Database.groupRepository.update(
                    Either.Left(texts[0].text),
                    Database.specialityRepository.getIdByTitle(texts[1].text).let {
                        when (it) {
                            None -> null
                            is Some -> Either.Right(it.value)
                        }
                    },
                    Some(selectedId).toEither { String() }
                ).let { res ->
                    when (res) {
                        None -> failureMessage()
                        else -> successMessage("Group updated")
                    }

                    window.isVisible = false
                }
            }
        }
    }

    override fun show() {
        gs.window.isVisible = true
    }
}