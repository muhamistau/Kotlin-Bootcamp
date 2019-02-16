import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")
    feedTheFish()

    repeat(2) {
        println("A fish is swimming")
    }

    eagerExample()
}

fun eagerExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    val eager = decorations.filter { it[0] == 'p' } // filter every elements that starts with p (') means char
    println(eager)

    // Apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    // Apply map lazily
    val lazyMap = decorations.asSequence().map {
        println("map: $it")
        it
    }

    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    print("Today is $day and the fish eat $food")
//    shouldChangeWater(day, 20, 50) // Normal argument(s)
//    shouldChangeWater(day) // Required argument(s) only
//    shouldChangeWater(day, dirty = 50) // Required and optional argument(s) with argument name specified

    if (shouldChangeWater(day)) {
        println(", Change the water today")
    }
}

fun randomDay() : String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "red worms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun getDirtySensorReading() = 20

fun shouldChangeWater(day: String, temp: Int = 22, dirty: Int = getDirtySensorReading()) : Boolean {
//    val isTooHot = temp > 30
//    val isTooDirty = dirty > 30
//    val isSunday = day == "Sunday"

    fun isTooHot(temp: Int) = temp > 30
    fun isTooDirty(dirty: Int) = dirty > 30
    fun isSunday(day: String) = day == "Sunday"

    return when {
        isTooHot(temp) -> true
        isTooDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

var dirty = 20

val waterFilter: (Int)-> Int = { dirty -> dirty / 2}
fun feedFish(dirty: Int) = dirty +10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) { dirty -> dirty + 50 }
}