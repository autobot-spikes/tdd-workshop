package com.ka.workshop.tdd.exercise3

class MarsRover(val command: String, val instruction: String,  var x: Int, var y: Int, var direction: Direction) {
    fun turnLeft() {
        direction = when (direction) {
            Direction.North -> Direction.West
            Direction.West -> Direction.South
            Direction.South -> Direction.East
            else -> Direction.North
        }
    }

    fun turnRight() {
        direction = when (direction) {
            Direction.North -> Direction.East
            Direction.East -> Direction.South
            Direction.South -> Direction.West
            else -> Direction.North
        }
    }

    fun setupPosition() {
        var positions = command.split(" ")
        x = positions[0].toInt()
        y = positions[1].toInt()
        direction = when (positions[2]){
            "N" -> Direction.North
            "E" -> Direction.East
            "S" -> Direction.South
            "W" -> Direction.West
            else -> direction
        }
    }

    fun move() {
        val inst = instruction.toCharArray()
        for(move in inst) {
            when (move) {
                'M' -> forward()
                'R' -> turnRight()
                else -> turnLeft()
            }
        }
    }

    private fun forward() {
        when(direction) {
            Direction.North -> y++
            Direction.East -> x++
            Direction.South ->y--
            else -> x--
        }
    }
}