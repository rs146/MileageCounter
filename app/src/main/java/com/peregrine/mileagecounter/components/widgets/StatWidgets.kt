package com.peregrine.mileagecounter.components.widgets

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.peregrine.mileagecounter.R
import com.peregrine.mileagecounter.ui.theme.MileageCounterTheme

@Composable
fun Stats(milesCompleted: Double, journeysCompleted: Int, averageMilesPerTrip: Double) {
    Row(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(modifier = Modifier.weight(1f)) {
            TotalMiles(Modifier.fillMaxWidth(), milesCompleted)
        }
        Box(modifier = Modifier.weight(1f)) {
            JourneyCompleted(Modifier.fillMaxWidth(), journeysCompleted)
        }
        Box(modifier = Modifier.weight(1f)) {
            AverageMilesPerMonth(Modifier.fillMaxWidth(), averageMilesPerTrip)
        }
    }
}

@Composable
fun TotalMiles(modifier: Modifier = Modifier, milesCompleted: Double) {
    StatWidget(
        modifier = modifier,
        icon = R.drawable.trending_up,
        text = R.string.total_miles,
        value = milesCompleted.toInt()
    )
}

@Composable
fun JourneyCompleted(modifier: Modifier = Modifier, journeysCompleted: Int) {
    StatWidget(
        modifier = modifier,
        icon = R.drawable.trip,
        text = R.string.journeys_completed,
        value = journeysCompleted
    )
}

@Composable
fun AverageMilesPerMonth(modifier: Modifier = Modifier, averageMilesPerTrip: Double) {
    StatWidget(
        modifier = modifier,
        icon = R.drawable.average_target,
        text = R.string.avg_miles_per_trip,
        value = averageMilesPerTrip.toInt()
    )
}

@Composable
fun StatWidget(modifier: Modifier = Modifier, @DrawableRes icon: Int, @StringRes text: Int, value: Int) {
    Surface(
        modifier = modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 2.dp,
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(4.dp)
                    ),
                painter = painterResource(id = icon),
                contentDescription = "Total Miles",
                tint = MaterialTheme.colorScheme.onTertiaryContainer
            )
            Text(
                text = "$value",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview
@Composable
fun PreviewTotalMiles() {
    MileageCounterTheme {
        TotalMiles(milesCompleted = 32.0)
    }
}

@Preview
@Composable
fun PreviewJourneyCompleted() {
    MileageCounterTheme {
        JourneyCompleted(journeysCompleted = 1)
    }
}

@Preview
@Composable
fun PreviewAverageMilesPerMonth() {
    MileageCounterTheme {
        AverageMilesPerMonth(averageMilesPerTrip = 32.0)
    }
}

@Preview
@Composable
fun PreviewStats() {
    MileageCounterTheme {
        Stats(milesCompleted = 32.0, journeysCompleted = 1, averageMilesPerTrip = 32.0)
    }
}