package com.peregrine.mileagecounter.components.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.peregrine.mileagecounter.R
import com.peregrine.mileagecounter.data.MileageEntry
import com.peregrine.mileagecounter.ui.theme.MileageCounterTheme
import com.peregrine.mileagecounter.util.formatDateOfTravel
import java.time.LocalDateTime

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

@Composable
fun JourneyCard(mileageEntry: MileageEntry) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            mileageEntry.apply {
                FirstRowMileageCard(mileageEntry)
                StartEndLocationRow(from, to)
                JourneyCommentsRow(description)
            }
        }
    }
}

@Composable
fun JourneyCommentsRow(description: String) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(start = 44.dp, end = 8.dp, bottom = 4.dp),
            text = description,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun StartEndLocationRow(from: String, to: String) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 12.dp, end = 8.dp, bottom = 4.dp)
                .size(16.dp)
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(16.dp)
                ),
            painter = painterResource(id = R.drawable.location),
            contentDescription = stringResource(R.string.start_end_location),
            tint = Color.Gray
        )
        Text(
            modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
            text = from,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary
        )
        Icon(
            modifier = Modifier
                .padding(start = 4.dp, end = 4.dp, bottom = 8.dp, top = 4.dp)
                .size(10.dp)
                .background(
                    color = Color.Transparent
                ),
            painter = painterResource(id = R.drawable.arrow_forward),
            contentDescription = stringResource(R.string.to),
            tint = MaterialTheme.colorScheme.secondary
        )
        Text(
            modifier = Modifier.padding(bottom = 4.dp),
            text = to,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun FirstRowMileageCard(
    mileageEntry: MileageEntry,
    onDeleteMileageEntry: (MileageEntry) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(4.dp)
                .size(32.dp)
                .background(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(16.dp)
                ),
            painter = painterResource(id = R.drawable.near_me),
            contentDescription = stringResource(R.string.miles_for_this_trip),
            tint = MaterialTheme.colorScheme.onTertiaryContainer
        )
        Column(
            modifier = Modifier
                .padding(top = 2.dp, start = 4.dp)
                .weight(1f)
        ) {
            Text(
                text = mileageEntry.formatDateOfTravel(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary
            )
            Row(
                modifier = Modifier.padding(top = 6.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    modifier = Modifier.alignByBaseline(),
                    text = "${mileageEntry.mileage.toInt()}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .alignByBaseline(),
                    text = stringResource(R.string.miles),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
        IconButton(
            onClick = { onDeleteMileageEntry(mileageEntry) },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp)
                    .background(
                        color = Color.Transparent
                    ),
                painter = painterResource(R.drawable.delete),
                contentDescription = stringResource(R.string.delete_journey),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Preview
@Composable
fun JourneyHistoryHeaderPreview() {
    MileageCounterTheme {
        JourneyHistoryHeader()
    }
}

@Preview
@Composable
fun JourneyCardPreview() {
    val localDateTime = LocalDateTime.now()
    val mileageEntry = MileageEntry(
        date = localDateTime,
        mileage = 32.0,
        from = "Chelmsford",
        to = "Seven Kings",
        description = "Along M25, M11",
        month = localDateTime.monthValue,
        year = localDateTime.year
    )

    MileageCounterTheme {
        JourneyCard(mileageEntry = mileageEntry)
    }
}

@Composable
@Preview
fun FirstRowMileageCardPreview() {
    val localDateTime = LocalDateTime.now()
    val mileageEntry = MileageEntry(
        date = localDateTime,
        mileage = 32.0,
        from = "Chelmsford",
        to = "Seven Kings",
        description = "Along M25, M11",
        month = localDateTime.monthValue,
        year = localDateTime.year
    )

    MileageCounterTheme {
        FirstRowMileageCard(mileageEntry)
    }
}