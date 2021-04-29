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
import java.awt.Rectangle

internal abstract class AbstractUpdateTitle<T>(
    title: String,
    selector: AbstractSelector<T>,
    repository: Repository,
) : ChangeWindow(title, "Title")
        where T : StringContent,
              T : WithId {
    init {
        action = null
        window.isVisible = false
        text = title

        this.addActionListener {
            selector.window.isVisible = true

            selector.addSelectionListener { selectedId ->
                selector.window.isVisible = false
                window.bounds = Rectangle(400, 300, 300, 100)
                window.isVisible = true

                ok.addActionListener {
                    repository.update(
                        Either.Left(texts[0].text),
                        Some(selectedId).toEither { String() }
                    ).let { res ->
                        when (res) {
                            None -> failureMessage()
                            is Some -> successMessage("${title.trim().split(' ').last()} updated")
                        }

                        window.isVisible = false
                    }
                }
            }
        }
    }
}