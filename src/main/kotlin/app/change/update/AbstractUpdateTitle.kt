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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.JFrame
import javax.swing.JScrollPane

internal abstract class AbstractUpdateTitle<T>(
    title: String,
    selector: AbstractSelector<T>,
    repository: Repository<T>,
) : ChangeWindow(title, "Title")
        where T : StringContent,
              T : WithId {
    private val selectWindow = JFrame(selector.title)
        .apply {
            bounds = Rectangle(400, 300, 300, 400)
            contentPane.add(
                JScrollPane(selector.table.table),
                BorderLayout.CENTER
            )
        }

    init {
        window.isVisible = false
        text = title

        addActionListener {
            selectWindow.isVisible = true

            GlobalScope.launch {
                while (selectWindow.isVisible) {
                    if (selector.selectedId is Some) {
                        selector.selectedId.takeIf { it is Some }?.let { id ->
                            selectWindow.isVisible = false
                            window.isVisible = true

                            ok.addActionListener { e ->
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