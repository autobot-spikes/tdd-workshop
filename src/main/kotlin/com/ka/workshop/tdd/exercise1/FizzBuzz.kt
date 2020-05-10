package com.ka.workshop.tdd.exercise1

class FizzBuzz {
    private fun fizz(n: Int) = n % 3 == 0
    private fun buzz(n: Int) = n % 5 == 0

    fun convert(number: Int): String {
        return if (fizz(number) && buzz(number)) "FizzBuzz"
            else if (fizz(number)) "Fizz"
            else if (buzz(number)) "Buzz"
            else number.toString()
    }
}
