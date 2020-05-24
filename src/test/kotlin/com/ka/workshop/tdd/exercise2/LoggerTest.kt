package com.ka.workshop.tdd.exercise2

import io.kotest.core.spec.style.FreeSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.io.Writer
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class LoggerTest : FreeSpec({
    "Should write 'dd-MM-YYYY HH:mm:ss Hello World!'" - {
        val writer = mockk<Writer>(relaxed = true)
        val calendar = mockk<Calendar>(relaxed = true)
        val mockDate = LocalDateTime.of(2020,5,15,10,10,10).atZone(ZoneId.systemDefault()).toInstant()
        every { calendar.time } returns Date.from(mockDate)
        val logger = Logger(writer,calendar)

        logger.log("Hello World!")
        
        verify { writer.write("15-05-2020 10:10:10 Hello World!") }
    }
})
