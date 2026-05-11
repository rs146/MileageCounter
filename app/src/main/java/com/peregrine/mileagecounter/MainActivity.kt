package com.peregrine.mileagecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.peregrine.mileagecounter.navigation.MileageAppNavigation
import com.peregrine.mileagecounter.screen.monthlymileage.viewmodel.MonthlyMileageViewModel
import com.peregrine.mileagecounter.ui.theme.MileageCounterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val monthlyMileageViewModel: MonthlyMileageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MileageCounterApp {
                MileageAppNavigation(monthlyMileageViewModel)
            }
        }
    }
}

@Composable
fun MileageCounterApp(content: @Composable () -> Unit) {
    MileageCounterTheme {
        content()
    }
}