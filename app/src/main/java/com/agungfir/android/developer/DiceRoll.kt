package com.agungfir.android.developer

fun main() {
    val diceRange: IntRange = 1..6

    val randomNumber = diceRange.random()

    println("Random number: ${randomNumber}")
    println("Random number: ${diceRange.random()}")

    val myFirstDice = Dice(10)
    myFirstDice.sides = 20
    val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
}

/**
 * Dice with a fixed number of sides.
 */
class Dice(private val numSides: Int) {

    var sides: Int = numSides

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        val randomNumber = (1..numSides).random()
        return randomNumber
    }
}