package com.ka.workshop.tdd.exercise3

class Controller(var rover: Rover) {
    fun takeAction (action: Char) {
        rover.move()
    }
}