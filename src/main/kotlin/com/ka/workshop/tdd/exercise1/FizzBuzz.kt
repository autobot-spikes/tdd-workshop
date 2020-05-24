package com.ka.workshop.tdd.exercise1

class FizzBuzz {
    fun convert(number: Int): String {
        val multipleOf3 = number % 3 == 0
        val multipleOf5 = number % 5 == 0
        return if (!multipleOf3 && !multipleOf5) number.toString()
        else if (multipleOf3 && !multipleOf5) "Fizz"
        else if (!multipleOf3 && multipleOf5) "Buzz"
        else "FizzBuzz"
    }
}
