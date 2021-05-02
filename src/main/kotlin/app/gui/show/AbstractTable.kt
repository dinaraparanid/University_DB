package app.gui.show

import app.core.polymorphism.Entity
import app.core.polymorphism.Showable
import java.awt.BorderLayout
import java.awt.Rectangle
import javax.swing.*

internal abstract class AbstractTable<T : Entity>(
    private val title: String,
    private val content: () -> Array<T>,
    private vararg val params: String
) : Showable {
    val cnt = content()

    fun table() = object : JTable(
        content().map { it.asStringArray() }.toTypedArray(),
        params
    ) {
        override fun isCellEditable(row: Int, column: Int) = false

        init {
            cellSelectionEnabled = false
        }
    }

    override fun show() {
        JFrame(title).apply {
            bounds = Rectangle(400, 300, 300, 400)
            contentPane.add(
                JScrollPane(table()),
                BorderLayout.CENTER
            )
        }.isVisible = true
    }
}