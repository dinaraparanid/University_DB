package app.gui.show

import app.core.polymorphism.Entity
import java.awt.BorderLayout
import java.awt.Rectangle
import java.awt.event.ActionEvent
import javax.swing.*

internal abstract class AbstractTable<T>(
    title: String,
    content: () -> Array<T>,
    vararg params: String
) : JMenuItem()
        where T : Entity {
    val cnt = content()

    var table = object : JTable(
        cnt
            .map { it.asStringArray() }
            .toTypedArray(),
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
                table = object : JTable() {
                    override fun isCellEditable(row: Int, column: Int) = false
                }

                JFrame(title)
                    .apply {
                        bounds = Rectangle(400, 300, 300, 400)

                        table = object : JTable(
                            cnt
                                .map { it.asStringArray() }
                                .toTypedArray(),
                            params
                        ) {
                            override fun isCellEditable(row: Int, column: Int) = false

                            init {
                                cellSelectionEnabled = false
                            }
                        }

                        contentPane.add(
                            JScrollPane(table),
                            BorderLayout.CENTER
                        )
                    }
                    .isVisible = true
            }
        }
    }
}