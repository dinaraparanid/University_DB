package app.show

import app.core.polymorphism.StringContent
import java.awt.BorderLayout
import java.awt.Rectangle
import java.awt.event.ActionEvent
import javax.swing.*

internal abstract class ContentTable<T>(
    title: String,
    content: () -> Array<T>,
    vararg params: String
) : JMenuItem()
        where T : StringContent {
    val cnt = content()

    var table = JTable(
        cnt
            .map { it.asStringArray() }
            .toTypedArray(),
        params
    ).apply { cellSelectionEnabled = false }

    init {
        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
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
    }
}