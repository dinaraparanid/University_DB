package app.core.date

import arrow.core.None
import arrow.core.Some
import java.time.LocalDate
import java.time.ZoneId
import java.util.Calendar

internal data class Date(private var day: Int, private var month: Int, private var year: Int) : Comparable<Date> {
    constructor() : this(
        LocalDate.now().dayOfMonth,
        LocalDate.now().monthValue,
        LocalDate.now().year
    )

    companion object {
        fun fromStr(str: String) =
            try {
                Some(
                    str
                        .trim()
                        .split('/')
                        .map { it.toInt() }
                        .let { Date(it[0], it[1], it[2]) }
                )
            } catch (e: Exception) {
                None
            }
    }

    override fun compareTo(other: Date) = when {

        year < other.year -> -1
        year > other.year -> 1
        else -> when {
            month < other.month -> -1
            month > other.month -> 1
            else -> day.compareTo(other.day)
        }
    }

    override fun toString() = "$day/$month/$year"

    operator fun rangeTo(other: Date) = DateProgression(this.toLocalDate(), other.toLocalDate())

    fun toLocalDate(): LocalDate = Calendar
        .getInstance()
        .apply {
            clear()
            set(year, month, day)
        }
        .toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
}
