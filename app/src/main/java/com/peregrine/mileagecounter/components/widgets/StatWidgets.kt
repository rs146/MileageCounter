package com.peregrine.mileagecounter.components.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
fun TotalMiles(milesCompleted: Double) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 2.dp,
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Icon(
                modifier = Modifier.size(24.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(4.dp)
                    )
                ,
                painter = painterResource(id = R.drawable.trending_up),
                contentDescription = "Total Miles",
                tint = MaterialTheme.colorScheme.onTertiaryContainer
            )
            Text(
                text = "$milesCompleted",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = stringResource(R.string.total_miles),
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