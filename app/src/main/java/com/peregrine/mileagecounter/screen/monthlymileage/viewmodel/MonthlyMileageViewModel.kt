package com.peregrine.mileagecounter.screen.monthlymileage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peregrine.mileagecounter.data.MileageEntry
import com.peregrine.mileagecounter.repository.MileageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class MonthlyMileageViewModel @Inject constructor(private val mileageRepository: MileageRepository) :
    ViewModel() {

    init {
        Calendar.getInstance().apply {
            val month = get(Calendar.MONTH)
            val year = get(Calendar.YEAR)
            getAllMileageEntriesForMonth(month, year)
        }
    }

    private val _monthlyMileageEntries = MutableStateFlow<List<MileageEntry>>(emptyList())
    val monthlyMileageEntries: StateFlow<List<MileageEntry>> = _monthlyMileageEntries.asStateFlow()

    fun addMileageEntry(mileageEntry: MileageEntry) {
        viewModelScope.launch { mileageRepository.insertMileageEntry(mileageEntry) }
    }

    fun getAllMileageEntriesForMonth(month: Int, year: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            mileageRepository.getMonthlyMileage(month, year)
                .collect { mileageEntries ->
                    _monthlyMileageEntries.value = mileageEntries
                }
        }
    }
}