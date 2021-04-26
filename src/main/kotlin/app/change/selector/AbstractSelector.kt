package app.change.selector

import app.core.polymorphism.StringContent
import app.core.polymorphism.WithId
import app.show.ContentTable
import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import kotlinx.coroutines.runBlocking
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.JFrame
import javax.swing.JScrollPane

internal abstract class AbstractSelector<T>(
    private val title: String,
    tab: ContentTable<T>
) where T : StringContent,
        T : WithId {
    private val table = tab.apply {
        action = null
        text = title
        table.cellSelectionEnabled = true
    }

    val selectedId: Option<Int>
        get() = when (table.cnt.isEmpty()) {
            true -> None
            else -> runBlocking {
                while (table.isVisible && table.table.selectedRow == -1) Unit

                table.cnt.getOrNull(table.table.selectedRow).let {
                    when (it) {
                        null -> None
                        else -> Some(it.id())
                    }
                }
            }
        }

    fun show() {
        JFrame(title)
            .apply {
                bounds = Rectangle(400, 300, 300, 400)
                contentPane.add(
                    JScrollPane(table),
                    BorderLayout.CENTER
                )
            }
            .isVisible = true
    }
}