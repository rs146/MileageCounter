package com.peregrine.mileagecounter.data

import android.database.sqlite.SQLiteDatabase
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MileageDao {

    @Insert(onConflict = SQLiteDatabase.CONFLICT_REPLACE)
    suspend fun insertMileageEntry(mileageEntry: MileageEntry)

    @Delete
    suspend fun deleteMileageEntry(mileageEntry: MileageEntry)

    @Query("SELECT * FROM mileage_table ORDER BY date DESC")
    fun getAllMileageEntries(): Flow<List<MileageEntry>>

    @Query("SELECT * FROM mileage_table WHERE month = :month AND year = :year ORDER BY date DESC")
    fun getMileageEntriesByMonth(month: Int, year: Int): Flow<List<MileageEntry>>
}