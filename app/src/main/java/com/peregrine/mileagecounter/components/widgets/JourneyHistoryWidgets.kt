package com.peregrine.mileagecounter.components.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.peregrine.mileagecounter.R
import com.peregrine.mileagecounter.ui.theme.MileageCounterTheme

@Composable
fun JourneyHistoryHeader(tripsCompletedInMonth: Int = 0) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.journey_history),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = pluralStringResource(
                R.plurals.trips,
                tripsCompletedInMonth,
                tripsCompletedInMonth
            ),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
fun JourneyHistoryHeaderPreview() {
    MileageCounterTheme {
        JourneyHistoryHeader()
    }
}