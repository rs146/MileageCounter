package com.peregrine.mileagecounter.screen.monthlymileage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MonthlyMileageScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .padding(24.dp)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column {
            Text(text = "Monthly Mileage Screen", fontSize = 16.sp)
        }
    }
}