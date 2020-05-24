package com.ka.workshop.tdd.exercise2

import java.io.Writer
import java.text.SimpleDateFormat
import java.util.*

class Logger(val writer: Writer, var calendar: Calendar) {
    fun log(message: String) {
        val now = SimpleDateFormat("dd-MM-YYYY HH:mm:ss").format(calendar.time)
        writer.write("$now $message")
    }
}
