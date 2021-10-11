import java.util.*
import kotlin.Comparable

val now = Calendar.getInstance()

class Date (
    val year: Int = now.get(Calendar.YEAR),
    val month: Int = now.get(Calendar.MONTH),
    val day: Int = now.get(Calendar.DAY_OF_MONTH)
) :Comparable<Date> {
    override fun compareTo(other: Date) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> day - other.day
    }
}


fun toString(myDate: Date) {
    println("Date is: ${myDate.year}.${myDate.month}.${myDate.day}")
}

fun isLeapYear (myDate: Date) : Boolean{
    val trueFalse = when {
        myDate.year % 4 == 0 -> true
        else -> false
    }

    return trueFalse
}

fun isValid(myDate: Date) : Boolean {
    var trueFalse = when {
        myDate.year > 2021 -> return false
        myDate.month !in 1..12 -> return false
        isLeapYear(myDate) && myDate.month == 2 && myDate.day == 29 -> true
        myDate.month == 2 && myDate.day in 1..28 -> true
        myDate.month % 2 == 1 && myDate.month in 1..7 && myDate.day in 1..31 -> return true
        myDate.month % 2 == 0 && myDate.month in 8..12 && myDate.day in 1..31 -> return true
        myDate.month % 2 == 1 && myDate.month in 8..12 && myDate.day in 1..30 -> return true
        myDate.month % 2 == 0 && myDate.month in 1..7 && myDate.day in 1..30 -> return true

        else -> false
    }

    return trueFalse
}
