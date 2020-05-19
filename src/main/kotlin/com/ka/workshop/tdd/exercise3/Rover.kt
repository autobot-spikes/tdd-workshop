package com.ka.workshop.tdd.exercise3

class Rover(var x: Int, var y: Int, var direction: Direction) {

    fun turnLeft() {
        direction = when (direction) {
            Direction.NORTH -> Direction.WEST
            Direction.WEST -> Direction.SOUTH
            Direction.SOUTH -> Direction.EAST
            Direction.EAST -> Direction.NORTH
        }
    }
    fun turnRight() {
        direction = when (direction) {
            Direction.WEST -> Direction.NORTH
            Direction.SOUTH -> Direction.WEST
            Direction.EAST -> Direction.SOUTH
            Direction.NORTH -> Direction.EAST
        }
    }

    fun move() {
        when (direction) {
            Direction.NORTH -> y++
            Direction.EAST -> x++
            Direction.SOUTH -> y--
            Direction.WEST -> x--
        }
    }
}
