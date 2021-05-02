package app.gui.change.selector

import app.core.polymorphism.Entity
import app.gui.show.AbstractTable
import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTable

internal abstract class AbstractSelector<T>(
    val title: String,
    private val tab: AbstractTable<T>
) where T : Entity {
    private val table: JTable
        get() = tab.run {
            table().apply {
                cellSelectionEnabled = true
                selectionModel.addListSelectionListener {
                    cnt.getOrNull(selectedRow).let {
                        selectedId = when (it) {
                            null -> None
                            else -> Some(it.id())
                        }
                    }
                }
            }
        }

    private var selectedId: Option<Int>? = null

    val window = JFrame(title).apply {
        bounds = Rectangle(400, 300, 300, 400)
        contentPane.add(
            JScrollPane(table),
            BorderLayout.CENTER
        )
    }

    inline fun addSelectionListener(crossinline func: (Int) -> Unit) {
        GlobalScope.launch {
            while (true) {

                // I don't know why, but it helps to run new coroutines.
                // So, don't remove this print (don't work without it)

                print("")

                if (selectedId is Some) {
                    func(selectedId!!.orNull()!!)
                    break
                }
            }
        }
    }
}