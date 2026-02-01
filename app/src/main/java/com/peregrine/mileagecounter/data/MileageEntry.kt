package com.peregrine.mileagecounter.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "mileage_table")
data class MileageEntry(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: Date,
    val mileage: Double,
    val from: String,
    val to: String,
    val description: String,
    val month: Int,
    val year: Int
)