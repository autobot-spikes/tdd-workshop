package com.ka.workshop.tdd.exercise2

import io.kotest.core.spec.style.FreeSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.io.Writer
import java.util.*

class LoggerTest : FreeSpec({
    "should log message with current formatted time" - {
        val message = "my message"
        val writer = mockk<Writer>(relaxed = true)
        val calendar = mockk<Calendar>(relaxed = true)
        val logger = Logger(writer, calendar)
        every { calendar.time } returns Date(1589192448683)

        logger.log(message)

        verify { writer.write("11-05-2020 10:20:48 $message") }
    }
})
