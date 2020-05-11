package com.ka.workshop.tdd.exercise2

import java.io.Writer
import java.text.SimpleDateFormat
import java.util.*

class Logger(private val writer: Writer, private val calendar: Calendar) {
    private val dateFormatter = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")

    init {
        dateFormatter.timeZone = TimeZone.getTimeZone("GMT")
    }

    fun log(message: String) {
        val now = dateFormatter.format(calendar.time)
        writer.write("$now $message")
    }
}
