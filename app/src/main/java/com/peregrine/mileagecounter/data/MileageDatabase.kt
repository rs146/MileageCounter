package com.peregrine.mileagecounter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.peregrine.mileagecounter.util.Converters

@Database(entities = [MileageEntry::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MileageDatabase : RoomDatabase() {

    abstract fun mileageDao(): MileageDao

    companion object {
        private const val DB_NAME: String = "mileage_db"

        fun getInstance(context: Context): MileageDatabase = Room.databaseBuilder(
            context,
            MileageDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration(true)
            .build()
    }

}