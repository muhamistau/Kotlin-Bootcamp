import java.util.*

fun main(args: Array<String>) {
//    println("Your fortune is: ${getFortuneCookie()}")

    // Extra
    var fortune: String
    for (i in 1..10) {
        fortune = getFortuneCookie()
        println("Your fortune is: ${getFortuneCookie()}")
        if (fortune.contains("Take")) break
    }
}

fun getFortuneCookie() : String {

    val fortuneList: List<String> = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    print("\nEnter your birthday: ")

    val birthday = readLine()?.toIntOrNull() ?: 1

    return fortuneList[birthday.rem(fortuneList.size)]
}