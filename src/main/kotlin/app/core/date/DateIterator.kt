package app.core.date

import java.time.LocalDate

internal class DateIterator(
    val startDate: LocalDate,
    val endDateInclusive: LocalDate,
    val stepDays: Long
) : Iterator<LocalDate> {
    private var currentDate = startDate

    override fun hasNext() = currentDate <= endDateInclusive

    override fun next(): LocalDate {
        val next = currentDate
        currentDate = currentDate.plusDays(stepDays)
        return next
    }
}