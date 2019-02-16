import java.util.*

fun main(args: Array<String>) {
//    println("Your fortune is: ${getFortuneCookie()}")

    // Extra
    var fortune: String
    for (i in 1..10) {
        fortune = getFortuneCookie(getBirthday())
        println("Your fortune is: $fortune")
        if (fortune.contains("Take")) break
    }
}

fun getFortuneCookie(birthday: Int) : String {
    val fortuneList: List<String> = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    val index = when (birthday) {
        in 1..7 -> 4
        28,31 -> 2
        else -> birthday.rem(fortuneList.size)
    }
    return fortuneList[index]
}

fun getBirthday() : Int {
    print("\nEnter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}