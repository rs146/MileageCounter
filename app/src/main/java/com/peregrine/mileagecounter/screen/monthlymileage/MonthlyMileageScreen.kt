package com.peregrine.mileagecounter.screen.monthlymileage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.peregrine.mileagecounter.components.widgets.MonthSelectorContainer
import com.peregrine.mileagecounter.components.widgets.Stats
import com.peregrine.mileagecounter.ui.theme.MileageCounterTheme

@Composable
fun MonthlyMileageScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .padding(24.dp)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column {
            MonthSelectorContainer(
                currentMonth = "March",
                currentYear = 2026,
                onPreviousMonthClick = { /* Handle previous month click */ },
                onNextMonthClick = { /* Handle next month click */ }
            )
            Stats(
                milesCompleted = 32.0,
                journeysCompleted = 1,
                averageMilesPerTrip = 32.0
            )
        }
    }
}

@Preview
@Composable
fun MonthlyMileageScreenPreview() {
    MileageCounterTheme {
        MonthlyMileageScreen(navController = NavController(LocalContext.current))
    }
}