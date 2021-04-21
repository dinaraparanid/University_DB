package app.show

import app.StringContent
import java.awt.BorderLayout
import java.awt.event.ActionEvent
import javax.swing.*

internal abstract class ContentTable<T>(
    title: String,
    content: () -> Array<T>,
    vararg params: String
) : JMenuItem(title)
        where T : StringContent {
    private val window = JFrame(title).apply {
        contentPane.add(
            JTable(
                content()
                    .map { it.asStringArray() }
                    .toTypedArray(),
                params
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