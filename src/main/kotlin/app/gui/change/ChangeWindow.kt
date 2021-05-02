package app.gui.change

import app.core.polymorphism.Showable
import java.awt.GridLayout
import java.awt.Rectangle
import javax.swing.*

internal abstract class ChangeWindow(
    title: String,
    vararg args: String,
) : Showable {
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

    override fun show() = window.run {
        bounds = Rectangle(400, 300, 300, 200)
        isVisible = true
    }
}