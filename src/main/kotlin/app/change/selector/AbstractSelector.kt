package app.change.selector

import app.core.polymorphism.StringContent
import app.core.polymorphism.WithId
import app.show.ContentTable
import arrow.core.None
import arrow.core.Some
import kotlinx.coroutines.runBlocking

internal abstract class AbstractSelector<T>(
    title: String,
    tab: ContentTable<T>
) where T : StringContent, T : WithId {
    private val table = tab.apply {
        text = title
        table.cellSelectionEnabled = true
    }

    fun getSelectedId() = when (table.cnt.isEmpty()) {
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
}