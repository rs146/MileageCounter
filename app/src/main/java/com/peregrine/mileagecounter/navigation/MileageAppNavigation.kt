package com.peregrine.mileagecounter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.peregrine.mileagecounter.screen.extendedhistory.ExtendedHistoryScreen
import com.peregrine.mileagecounter.screen.monthlymileage.MonthlyMileageScreen

@Composable
fun MileageAppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MileageAppScreens.MonthlyMileageScreen.name
    ) {
        composable(MileageAppScreens.MonthlyMileageScreen.name) {
            MonthlyMileageScreen(navController)
        }

        composable(MileageAppScreens.ExtendedHistoryScreen.name) {
            ExtendedHistoryScreen(navController)
        }
    }
}