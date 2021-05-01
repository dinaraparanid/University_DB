package app.gui.change

import java.awt.GridLayout
import java.awt.event.ActionEvent
import javax.swing.*

internal abstract class ChangeWindow(
    title: String,
    vararg args: String,
) : JMenuItem() {
    val ok = JButton("Ok")
    val texts = mutableListOf<JTextField>()

    val window = JFrame(title).apply {
        layout = GridLayout(1, 1, 25, 25)
        val panel = JPanel()

        args.forEach {
            val inp = JTextField(15).apply { isEditable = true }
            panel.add(JLabel("$it: "))
            panel.add(inp)
            texts.add(inp)
        }

        panel.add(ok)
        contentPane.add(panel)
    }

    init {
        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                window.isVisible = true
            }
        }
    }
}