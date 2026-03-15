package com.peregrine.mileagecounter.util

import com.peregrine.mileagecounter.data.MileageEntry
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class MileageEntryExtTest {

    @Test
    fun testFormatDateOfTravel() {
        val localDateTime = LocalDateTime.of(2026, 3, 15, 16, 44)
        val mileageEntry = MileageEntry(
            date = localDateTime,
            mileage = 32.0,
            from = "Chelmsford",
            to = "Seven Kings",
            description = "Along M25, M11",
            month = localDateTime.monthValue,
            year = localDateTime.year
        )

        val result = mileageEntry.formatDateOfTravel()

        assertEquals("Sunday, Mar 15", result)
    }
}