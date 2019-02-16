import java.util.*

fun main(args: Array<String>) {
    feedTheFish()
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    print("Today is $day and the fish eat $food")
    shouldChangeWater(day, 20, 50) // Normal argument(s)
    shouldChangeWater(day) // Required argument(s) only
    shouldChangeWater(day, dirty = 50) // Required and optional argument(s) with argument name specified

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }
}

fun randomDay() : String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun shouldChangeWater(day: String, temp: Int = 22, dirty: Int = 20) : Boolean {
    return true
}