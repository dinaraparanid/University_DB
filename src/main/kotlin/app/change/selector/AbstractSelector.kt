package app.change.selector

import app.core.polymorphism.StringContent
import app.core.polymorphism.WithId
import app.show.ContentTable
import arrow.core.Option
import arrow.core.Some

internal abstract class AbstractSelector<T>(
    val title: String,
    tab: ContentTable<T>
) where T : StringContent,
        T : WithId {
    val table = tab.apply {
        action = null
        text = title
        table.cellSelectionEnabled = true
    }

    var selectedId: Option<Int>? = null
        private set

    init {
        table.table.selectionModel.addListSelectionListener {
            table.cnt.getOrNull(table.table.selectedRow).let {
                selectedId = when (it) {
                    null -> null
                    else -> Some(it.id())
                }
            }
        }
    }
}