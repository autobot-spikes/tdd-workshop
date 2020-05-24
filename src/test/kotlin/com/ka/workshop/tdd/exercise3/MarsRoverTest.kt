package com.ka.workshop.tdd.exercise3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MarsRoverTest : FreeSpec ({

    "When turn left" - {
        forAll(
                row(Direction.North, Direction.West),
                row(Direction.West, Direction.South),
                row(Direction.South, Direction.East),
                row(Direction.East, Direction.North)
        ) { direction, expected ->
            val mr = MarsRover("","",0,0,direction)
            mr.turnLeft()
            mr.direction shouldBe expected
        }
    }
    "When turn right" - {
        forAll(
                row(Direction.North, Direction.East),
                row(Direction.East, Direction.South),
                row(Direction.South, Direction.West),
                row(Direction.West, Direction.North)
        ) { direction, expected ->
            val mr = MarsRover("","",0,0,direction)
            mr.turnRight()
            mr.direction shouldBe expected
        }
    }
    "When setup marsRover position"- {
        forAll(
                row("1 2 N", 1, 2, Direction.North),
                row("3 3 E", 3, 3, Direction.East)
        ){command, expectedX,expectedY, expectedDirection ->
            val mr = MarsRover(command,"", 0,0,Direction.South)
            mr.setupPosition()
            mr.x            shouldBe    expectedX
            mr.y            shouldBe    expectedY
            mr.direction    shouldBe    expectedDirection
        }
    }

    "When marsRover move" - {
    forAll(
            row("0 0 N","M", 0,1,Direction.North),
            row("0 0 N","MRM", 1,1,Direction.East),
            row("1 2 N","LMLMLMLMM", 1,3,Direction.North),
            row("3 3 E","MMRMMRMRRM", 5,1,Direction.East)
    ){position, instruction, expectedX, expectedY,expectedDirection ->
        val mr = MarsRover(position,instruction,0,0, Direction.South)
        mr.setupPosition()
        mr.move()
        mr.x            shouldBe    expectedX
        mr.y            shouldBe    expectedY
        mr.direction    shouldBe    expectedDirection
    }
}
}
)