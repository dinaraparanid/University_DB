package app.gui.show

import app.core.Database
import app.core.date.Date
import app.core.date.DateProgression
import app.core.polymorphism.Showable
import app.gui.change.selector.StudentSelector
import arrow.core.compareTo
import java.awt.BorderLayout
import java.awt.Rectangle
import java.time.LocalDate
import java.util.SortedMap
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTable

internal class MarkTable : Showable {
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
                    .filter { Date.fromStr(it.date).orNull()!!.toLocalDate() in range }
                    .map {
                        Triple(
                            Database.subjectRepository.getTitleById(it.subjectId),
                            Date.fromStr(it.date).orNull()!!,
                            it.mark
                        )
                    }
                    .sortedWith { f, s -> f.compareTo(s) }
                    .onEach {
                        mapContent.getOrPut(it.first) { sortedMapOf() }

                        mapContent[it.first]!![it.second] =
                            mapContent[it.first]!!.getOrPut(it.second) { "" } + "${it.third} "
                    }
                    .run {
                        mapContent.forEach { (_, u) ->
                            range.forEach { u.getOrPut(Date(it)) { "" } }
                        }
                    }
            }

        return JFrame("Marks").apply {
            bounds = Rectangle(200, 200, 800, 700)
            contentPane.add(
                JScrollPane(
                    JTable(
                        Array(mapContent.toList().map { it.first }.size) { Array(8) { "" } }.also { content ->
                            var ind = 0

                            mapContent.forEach { (subject, x) ->
                                content[ind++] = mutableListOf(subject).apply {
                                    addAll(
                                        x
                                            .values
                                            .toMutableList()
                                            .also { it.addAll(Array(maxOf(8 - it.size, 0)) { "" }) }
                                    )
                                }.toTypedArray()
                            }
                        },
                        mutableListOf("Subject").apply {
                            addAll(range.map { Date(it.dayOfMonth, it.monthValue, it.year).toString() })
                        }.toTypedArray()
                    )
                ),
                BorderLayout.CENTER
            )
        }
    }

    override fun show() {
        ss.window.isVisible = true
    }
}