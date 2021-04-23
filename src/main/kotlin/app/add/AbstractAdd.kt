package app.add

import java.awt.Rectangle
import java.awt.event.ActionEvent
import javax.swing.*

internal abstract class AbstractAdd(
    title: String,
    private vararg val args: String
) : JMenuItem() {
    private val window = JFrame(title).apply {
        bounds = Rectangle(400, 300, 300, 400)
        val lyt = SpringLayout()
        layout = lyt

        args.forEach {
            val label = JLabel("$it: ")
            val inp = JTextField(15).apply { isEditable = true }

            lyt.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, contentPane)
            lyt.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, contentPane)
            lyt.putConstraint(SpringLayout.WEST, inp, 5, SpringLayout.EAST, contentPane)
            lyt.putConstraint(SpringLayout.NORTH, inp, 5, SpringLayout.NORTH, contentPane)

            contentPane.add(label)
            contentPane.add(inp)
        }
    }

    init {
        action = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                window.isVisible = true
            }
        }
    }
}