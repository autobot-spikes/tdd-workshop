package com.ka.workshop.tdd.exercise3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe


class ControllerTest : FreeSpec({
    "should move forward when receive 'M'" {
        val rover = Rover(0, 0, Direction.NORTH)
        val controller = Controller(rover)

        controller.takeAction('M')

        controller.rover.direction shouldBe Direction.NORTH
        controller.rover.x shouldBe 0
        controller.rover.y shouldBe 1
    }
})