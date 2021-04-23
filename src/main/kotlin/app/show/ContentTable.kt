package app.show

import app.core.StringContent
import java.awt.*
import java.awt.event.ActionEvent
import javax.swing.*

internal abstract class ContentTable<T>(
    title: String,
    content: () -> Array<T>,
    vararg params: String
) : JMenuItem()
        where T : StringContent {
    private val window = JFrame(title).apply {
        bounds = Rectangle(400, 300, 300, 400)
        contentPane.add(
            JScrollPane(
                JTable(
                    content()
                        .map { it.asStringArray() }
                        .toTypedArray(),
                    params
                )
            ),
            BorderLayout.CENTER
        )
    }

    init {
        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                window.isVisible = true
            }
        }
    }
}