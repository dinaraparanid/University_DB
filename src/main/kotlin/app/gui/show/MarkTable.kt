package app.gui.show

import app.core.Database
import app.core.date.Date
import app.core.date.DateProgression
import app.gui.change.selector.StudentSelector
import arrow.core.compareTo
import java.awt.BorderLayout
import java.awt.Rectangle
import java.time.LocalDate
import java.util.SortedMap
import javax.swing.JFrame
import javax.swing.JMenuItem
import javax.swing.JScrollPane
import javax.swing.JTable

internal class MarkTable : JMenuItem() {
    private val ss = StudentSelector().apply {
        addSelectionListener { selectedId ->
            window.isVisible = false
            table(selectedId).isVisible = true
        }
    }

    fun table(studentId: Int): JFrame {
        val range = LocalDate.now().run { DateProgression(minusDays(6), this) }

        val mapContent = sortedMapOf<String, SortedMap<Date, String>>()
            .also { mapContent ->
                Database
                    .markRepository
                    .allByStudent(studentId)
                    .filter {
                        val s = it.date.trim().split('/')
                        Date(s[0].toInt(), s[1].toInt(), s[2].toInt()).toLocalDate() in range
                    }
                    .map {
                        Triple(
                            Database.subjectRepository.getTitleById(it.subjectId),
                            Date.fromStr(it.date).orNull()!!,
                            it.mark
                        )
                    }
                    .sortedWith { f, s -> f.compareTo(s) }
                    .forEach {
                        val c1 = mapContent.getOrPut(it.first) { sortedMapOf() }
                        mapContent[it.first] = c1

                        val c2 = mapContent[it.first]!!.getOrPut(it.second) { "" }
                        mapContent[it.first]!![it.second] = c2 + "${it.third} "
                    }
            }

        val subjects = mapContent.toList().map { it.first }.distinct()

        return JFrame("Marks")
            .apply {
                bounds = Rectangle(200, 200, 800, 700)
                contentPane.add(
                    JScrollPane(
                        JTable(
                            Array(8) { Array(subjects.size) { "" } }.also { content ->
                                var ind = 0

                                mapContent.forEach { (subject, x) ->
                                    content[ind++] = mutableListOf(subject).apply { addAll(x.values) }.toTypedArray()
                                }
                            },
                            mutableListOf("Subject")
                                .apply {
                                    addAll(
                                        range
                                            .map { Date(it.dayOfMonth, it.monthValue, it.year).toString() }
                                            .toTypedArray()
                                    )
                                }
                                .toTypedArray()
                        )
                    ),
                    BorderLayout.CENTER
                )
            }
    }

    init {
        addActionListener {
            ss.window.isVisible = true
        }

        text = "Student's marks"
    }
}