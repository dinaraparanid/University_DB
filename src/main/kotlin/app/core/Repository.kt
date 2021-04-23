package app.core

internal interface Repository<T> {
    sealed class Arg {
        data class Str(val str: String) : Arg()
        data class Integer(val int: Int) : Arg()

        fun parseIntArg() = when (this) {
            is Integer -> this.int
            else -> throw IllegalArgumentException("Param must be Int")
        }

        fun parseStrArg() = when (this) {
            is Str -> this.str
            else -> throw IllegalArgumentException("Param must be String")
        }
    }

    fun all(): Array<T>
    fun all(id: Int, mod: Int = 0): Array<T>
    fun add(vararg args: Arg): Unit?
    fun update(vararg args: Arg): Unit?
    fun remove(vararg args: Arg): Unit?
}