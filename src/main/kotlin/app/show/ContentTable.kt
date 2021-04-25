package app.show

import app.core.polymorphism.StringContent
import java.awt.*
import java.awt.event.ActionEvent
import javax.swing.*

internal abstract class ContentTable<T>(
    title: String,
    content: () -> Array<T>,
    vararg params: String
) : JMenuItem()
        where T : StringContent {
    init {
        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                JFrame(title)
                    .apply {
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
                    .isVisible = true
            }
        }
    }
}