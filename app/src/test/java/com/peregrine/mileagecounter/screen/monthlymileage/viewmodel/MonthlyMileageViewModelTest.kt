package com.peregrine.mileagecounter.screen.monthlymileage.viewmodel

import com.peregrine.mileagecounter.data.MileageEntry
import com.peregrine.mileagecounter.repository.MileageRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import java.time.Instant
import java.util.Date

class MonthlyMileageViewModelTest {

    private lateinit var viewModel: MonthlyMileageViewModel

    @MockK
    private lateinit var mileageRepository: MileageRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = MonthlyMileageViewModel(mileageRepository)
    }

    @Test
    fun addMileageEntry() {
        // setup:
        coEvery { mileageRepository.insertMileageEntry(any()) } returns Unit

        val mockMileageEntry = MileageEntry(
            date = Date.from(Instant.now()),
            mileage = 23.2,
            from = "Chelmsford",
            to = "London, Newbury Park",
            description = "Test trip",
            month = 11,
            year = 2025)

        // test:
        viewModel.addMileageEntry(mockMileageEntry)

        // verify:
        coVerify { mileageRepository.insertMileageEntry(mockMileageEntry) }
    }
}