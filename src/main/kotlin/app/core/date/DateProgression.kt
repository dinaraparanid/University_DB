package app.core.date

import java.time.LocalDate

internal class DateProgression(
    override val start: LocalDate,
    override val endInclusive: LocalDate,
    val stepDays: Long = 1
) : Iterable<LocalDate>, ClosedRange<LocalDate> {
    override fun iterator(): Iterator<LocalDate> = DateIterator(start, endInclusive, stepDays)
    infix fun step(days: Long) = DateProgression(start, endInclusive, days)
}