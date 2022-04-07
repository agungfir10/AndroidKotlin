fun main() {
    val age = 24
    val name = "Rover"
    val border = "`-._,-'"
    val timesToRepeat = 4
    val layers = 4

    println("Happy Birthday, $name!")

    // Let's print a cake!
    println("   ,,,,,   ")
    println("   |||||   ")
    println(" =========")
    println("@@@@@@@@@@@")
    println("{~@~@~@~@~}")
    println("@@@@@@@@@@@")
    println("")

    // This prints an empty line.
    println("")

    println("You are already $age!")
    println("$age is the very best age to celebrate!")

    printBorder(border, timesToRepeat)
    println("Happy Birthday, $name!")
    printBorder(border, timesToRepeat)
    printCakeCandles(age)
    printCakeTop(age)
    printCakeBottom(age, layers)

}

fun printBorder(border: String, timesToRepeat: Int) {
    repeat(timesToRepeat) {
        print(border)
    }
    println()
}

fun printCakeCandles(age: Int) {
    print(" ")
    repeat(age) {
        print(",")
    }
    println() // Print an empty line

    print(" ") // Print the inset of the candles on the cake
    repeat(age) {
        print("|")
    }
    println()
}

fun printCakeTop(age: Int) {
    repeat(age + 2) {
        print("=")
    }
    println()
}

fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}