package app.core.date

import arrow.core.None
import arrow.core.Some
import java.time.LocalDate
import java.time.ZoneId
import java.util.Calendar

internal class Date(d: Int, m: Int, y: Int) : Comparable<Date> {
    private var day = d
    private var month = m
    private var year = y

    constructor() : this(
        LocalDate.now().dayOfMonth,
        LocalDate.now().monthValue,
        LocalDate.now().year
    )

    constructor(date: Calendar) : this(
        date.get(Calendar.DAY_OF_WEEK),
        date.get(Calendar.MONTH),
        date.get(Calendar.YEAR) - 1900
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

    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass != other?.javaClass -> false
        else -> this.compareTo(other as Date) == 0
    }

    override fun toString() = "$day/$month/$year"

    override fun hashCode(): Int {
        var result = day
        result = 31 * result + month
        result = 31 * result + year
        return result
    }

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
