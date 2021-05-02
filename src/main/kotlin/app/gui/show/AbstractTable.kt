package app.gui.show

import app.core.polymorphism.Entity
import java.awt.BorderLayout
import java.awt.Rectangle
import java.awt.event.ActionEvent
import javax.swing.*

internal abstract class AbstractTable<T : Entity>(
    title: String,
    private val content: () -> Array<T>,
    private vararg val params: String
) : JMenuItem() {
    val cnt = content()

    val table: JTable
        get() = object : JTable(
            content().map { it.asStringArray() }.toTypedArray(),
            params
        ) {
            override fun isCellEditable(row: Int, column: Int) = false

            init {
                cellSelectionEnabled = false
            }
        }

    init {
        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                JFrame(title).apply {
                    bounds = Rectangle(400, 300, 300, 400)
                    table.updateUI()
                    contentPane.add(
                        JScrollPane(table),
                        BorderLayout.CENTER
                    )
                }.isVisible = true
            }
        }

        text = title
    }
}