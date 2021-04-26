package app.change.update

import app.change.ChangeWindow
import app.change.selector.GroupSelector
import app.core.Database
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

internal class GroupUpdate : ChangeWindow("Update Group", "Title", "Speciality title") {
    init {
        window.isVisible = false

        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                if (e?.source === this) {
                    GroupSelector().apply { show() }.selectedId.takeIf { it is Some }?.let { id ->
                        window.isVisible = true

                        ok.addActionListener { e ->
                            if (e?.source === ok) {
                                Database.groupRepository.update(
                                    Either.Left(texts[0].text),
                                    Database.specialityRepository.getIdByTitle(texts[1].text).let {
                                        when (it) {
                                            None -> null
                                            is Some -> Either.Right(it.value)
                                        }
                                    },
                                    id.toEither { String() }
                                ).let { res ->
                                    when (res) {
                                        None -> failureMessage()
                                        is Some -> successMessage("Group updated")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        text = "Update Group"
    }
}