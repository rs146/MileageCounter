package com.peregrine.mileagecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.peregrine.mileagecounter.navigation.MileageAppNavigation
import com.peregrine.mileagecounter.ui.theme.MileageCounterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MileageCounterApp {
                MileageAppNavigation()
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