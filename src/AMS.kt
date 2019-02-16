import java.util.*

fun main(args: Array<String>) {
    dayOfWeek(args)
}

fun dayOfWeek(args: Array<String>) {
    print("What day is it today, ${args[0]}?\n")
    when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
        1 -> print("Sunday")
        2 -> print("Monday")
        3 -> print("Tuesday")
        4 -> print("Wednesday")
        5 -> print("Thursday")
        6 -> print("Friday")
        7 -> print("Saturday")
    }

}