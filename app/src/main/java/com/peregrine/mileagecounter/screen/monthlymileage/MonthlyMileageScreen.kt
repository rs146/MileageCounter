package com.peregrine.mileagecounter.screen.monthlymileage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.peregrine.mileagecounter.components.widgets.JourneyHistoryHeader
import com.peregrine.mileagecounter.components.widgets.JourneyList
import com.peregrine.mileagecounter.components.widgets.MonthSelectorContainer
import com.peregrine.mileagecounter.components.widgets.Stats
import com.peregrine.mileagecounter.data.MileageEntry
import com.peregrine.mileagecounter.screen.monthlymileage.viewmodel.MonthlyMileageViewModel
import com.peregrine.mileagecounter.ui.theme.MileageCounterTheme
import java.time.LocalDateTime

@Composable
fun MonthlyMileageScreen(
    navController: NavController,
    viewModel: MonthlyMileageViewModel = viewModel()
) {
    val mileageEntries by viewModel.monthlyMileageEntries.collectAsState()

    MonthlyMileageContent(
        mileageEntries = mileageEntries,
        onDeleteMileageEntry = {
            //TODO: delete the mileage entry from the vm
        }
    )
}

@Composable
fun MonthlyMileageContent(
    mileageEntries: List<MileageEntry>,
    onDeleteMileageEntry: (MileageEntry) -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(24.dp)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column {
            Column(
                verticalArrangement = Arrangement.spacedBy((-64).dp)
            ) {
                MonthSelectorContainer(
                    currentMonth = "March",
                    currentYear = 2026,
                    onPreviousMonthClick = {
                        //TODO: Handle on previous month click
                    },
                    onNextMonthClick = {
                        //TODO: Handle on next month click
                    }
                )
                Stats(
                    milesCompleted = 32.0,
                    journeysCompleted = 1,
                    averageMilesPerTrip = 32.0
                )
            }
            JourneyHistoryHeader()
            JourneyList(
                mileageEntries = mileageEntries,
                onDeleteMileageEntry = onDeleteMileageEntry
            )
        }
    }
}

@Preview
@Composable
fun MonthlyMileageContentPreview() {
    val localDateTime = LocalDateTime.now()
    val mockMileageEntries = listOf(
        MileageEntry(
            date = localDateTime,
            mileage = 32.0,
            from = "Chelmsford",
            to = "Seven Kings",
            description = "Along M25, M11",
            month = localDateTime.monthValue,
            year = localDateTime.year
        ),
        MileageEntry(
            date = localDateTime.minusDays(1),
            mileage = 15.5,
            from = "London",
            to = "Cambridge",
            description = "Commute",
            month = localDateTime.monthValue,
            year = localDateTime.year
        )
    )
    MileageCounterTheme {
        MonthlyMileageContent(
            mileageEntries = mockMileageEntries,
            onDeleteMileageEntry = {}
        )
    }
}
