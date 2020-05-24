package com.ka.workshop.tdd.exercise1

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class FizzBuzzTest : FreeSpec({
    "should return Fizz, Buzz, FizzBuzz or number is number is a multiple of 3, 5, both or none" - {
        forAll(
                row(3,"Fizz"),
                row(5, "Buzz"),
                row(15, "FizzBuzz"),
                row(4,"4")
        ){ number, expected->
            val fizzBuzz = FizzBuzz()

            val result = fizzBuzz.convert(number)

            result shouldBe expected
        }
    }
})
