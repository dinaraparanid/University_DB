package app.gui.change.selector

import app.core.polymorphism.Entity
import app.gui.show.AbstractTable
import arrow.core.Option
import arrow.core.Some
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.JFrame
import javax.swing.JScrollPane

internal abstract class AbstractSelector<T>(
    val title: String,
    tab: AbstractTable<T>
) where T : Entity {
    private val table = tab.apply {
        action = null
        text = title
        table.cellSelectionEnabled = true

        table.selectionModel.addListSelectionListener {
            cnt.getOrNull(table.selectedRow).let {
                selectedId = when (it) {
                    null -> null
                    else -> Some(it.id())
                }
            }
        }
    }

    private var selectedId: Option<Int>? = null

    val window = JFrame(title)
        .apply {
            bounds = Rectangle(400, 300, 300, 400)
            contentPane.add(
                JScrollPane(table.table),
                BorderLayout.CENTER
            )
        }

    inline fun addSelectionListener(crossinline func: (selectedId: Int) -> Unit) {
        GlobalScope.launch {
            while (window.isVisible) {
                if (selectedId is Some) {
                    func(selectedId!!.orNull()!!)
                    break
                }
            }
        }
    }
}