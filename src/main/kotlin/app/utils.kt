package app

import arrow.core.Either
import java.sql.PreparedStatement
import javax.swing.JOptionPane

internal fun PreparedStatement.setValOrNull(ind: Int, v: Either<String, Int>?) = when (v) {
    is Either.Right -> setInt(ind, v.value)
    is Either.Left -> setString(ind, v.value)
    else -> setNull(ind, java.sql.Types.INTEGER)
}

internal fun successMessage(message: String) = JOptionPane.showMessageDialog(
    null,
    message,
    "Success",
    JOptionPane.INFORMATION_MESSAGE
)

internal fun failureMessage(message: String = "Something went wrong") = JOptionPane.showMessageDialog(
    null,
    message,
    "Failure",
    JOptionPane.INFORMATION_MESSAGE
)