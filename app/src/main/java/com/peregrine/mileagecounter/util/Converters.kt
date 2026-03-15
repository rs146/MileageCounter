package com.peregrine.mileagecounter.util

import androidx.room.TypeConverter
import java.time.LocalDateTime

class Converters {

    @TypeConverter
    fun toDate(dateString: String?): LocalDateTime? = dateString?.let { LocalDateTime.parse(it) }

    @TypeConverter
    fun toDateString(date: LocalDateTime?): String? = date?.let { date.toString() }
}