package com.ka.workshop.tdd.exercise3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RoverTest : FreeSpec({
    "should turn left" {
        forAll(
                row(Direction.NORTH, Direction.WEST),
                row(Direction.WEST, Direction.SOUTH),
                row(Direction.SOUTH, Direction.EAST),
                row(Direction.EAST, Direction.NORTH)
        ) { facingDirection, expectedDirection ->
            val rover = Rover(0, 0, facingDirection)

            rover.turnLeft()

            rover.direction shouldBe expectedDirection
        }
    }

    "should turn right" {
        forAll(
                row(Direction.NORTH, Direction.EAST),
                row(Direction.EAST, Direction.SOUTH),
                row(Direction.SOUTH, Direction.WEST),
                row(Direction.WEST, Direction.NORTH)
        ) { facingDirection, expectedDirection ->
            val rover = Rover(0, 0, facingDirection)

            rover.turnRight()

            rover.direction shouldBe expectedDirection
        }
    }

    "should move" {
        forAll(
                row(0, 0, Direction.NORTH, 0, 1),
                row(0, 0, Direction.EAST, 1, 0),
                row(1, 1, Direction.SOUTH, 1, 0),
                row(1, 1, Direction.WEST, 0, 1)
        ) { x, y, direction, expectedX, expectedY ->
            val rover = Rover(x, y, direction)

            rover.move()

            rover.x shouldBe expectedX
            rover.y shouldBe expectedY
        }
    }
})
