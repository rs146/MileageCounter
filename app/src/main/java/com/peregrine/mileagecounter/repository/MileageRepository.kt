package com.peregrine.mileagecounter.repository

import com.peregrine.mileagecounter.data.MileageDao
import com.peregrine.mileagecounter.data.MileageEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MileageRepository @Inject constructor(private val mileageDao: MileageDao) {

    suspend fun insertMileageEntry(mileageEntry: MileageEntry) {
        mileageDao.insertMileageEntry(mileageEntry)
    }

    suspend fun deleteMileageEntry(mileageEntry: MileageEntry) {
        mileageDao.deleteMileageEntry(mileageEntry)
    }

    fun getAllMileageEntries(): Flow<List<MileageEntry>> = mileageDao.getAllMileageEntries()
        .flowOn(Dispatchers.IO)

    fun getMonthlyMileage(month: Int, year: Int): Flow<List<MileageEntry>> =
        mileageDao.getMileageEntriesByMonth(month, year)
}