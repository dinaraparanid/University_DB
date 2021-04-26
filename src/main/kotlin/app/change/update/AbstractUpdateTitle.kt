package app.change.update

import app.change.ChangeWindow
import app.change.selector.AbstractSelector
import app.core.polymorphism.Repository
import app.core.polymorphism.StringContent
import app.core.polymorphism.WithId
import app.failureMessage
import app.successMessage
import arrow.core.Either
import arrow.core.None
import arrow.core.Some
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

internal abstract class AbstractUpdateTitle<T>(
    title: String,
    selector: AbstractSelector<T>,
    repository: Repository<T>,
) : ChangeWindow(title, "Title")
        where T : StringContent,
              T : WithId {
    init {
        window.isVisible = false
        text = title

        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                if (e?.source === this) {
                    selector.apply { show() }.selectedId.takeIf { it is Some }?.let { id ->
                        window.isVisible = true

                        ok.addActionListener { e ->
                            if (e?.source === ok) {
                                repository.update(
                                    Either.Left(texts[0].text),
                                    id.toEither { String() }
                                ).let { res ->
                                    when (res) {
                                        None -> failureMessage()
                                        is Some -> successMessage("${title.trim().split(' ').last()} updated")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}