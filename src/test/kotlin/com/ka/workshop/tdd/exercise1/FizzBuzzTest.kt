package com.ka.workshop.tdd.exercise1

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class FizzBuzzTest : FreeSpec({
    "Replace this test" - {
        val fizzBuzz = FizzBuzz()

        val result = fizzBuzz.convert()

        result shouldBe ""
    }
})
