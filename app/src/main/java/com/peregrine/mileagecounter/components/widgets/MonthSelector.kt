package com.peregrine.mileagecounter.components.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.peregrine.mileagecounter.R
import com.peregrine.mileagecounter.ui.theme.MileageCounterTheme

@Composable
fun MonthSelectorContainer(
    currentMonth: String,
    currentYear: Int = 2026,
    onPreviousMonthClick: () -> Unit = {},
    onNextMonthClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MileageTrackerTitle()
            MonthSelector(currentMonth, currentYear, onPreviousMonthClick, onNextMonthClick)
        }
    }
}

@Composable
fun MileageTrackerTitle() {
    Row(
        modifier = Modifier.padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .background(
                    color = Color.Gray.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(4.dp)
                ),
            painter = painterResource(R.drawable.car),
            contentDescription = stringResource(R.string.month_selector_title),
            tint = MaterialTheme.colorScheme.surface
        )
        Text(
            text = stringResource(R.string.month_selector_title),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.surface
        )
    }
}

@Composable
fun MonthSelector(currentMonth: String, currentYear: Int,
                  onPreviousMonthClick: () -> Unit = {},
                  onNextMonthClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onPreviousMonthClick() }
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        color = Color.Transparent
                    ),
                painter = painterResource(R.drawable.chevron_left),
                contentDescription = stringResource(R.string.previous_month),
                tint = MaterialTheme.colorScheme.surface,
            )
        }
        Text(
            text = "$currentMonth $currentYear",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.surface
        )
        IconButton(
            onClick = { onNextMonthClick() }
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        color = Color.Transparent
                    ),
                painter = painterResource(R.drawable.chevron_right),
                contentDescription = stringResource(R.string.next_month),
                tint = MaterialTheme.colorScheme.surface
            )
        }
    }
}

@Preview
@Composable
fun MileageTrackerTitlePreview() {
    MileageCounterTheme {
        MileageTrackerTitle()
    }
}

@Preview
@Composable
fun MonthSelectorPreview() {
    MileageCounterTheme {
        MonthSelector(currentMonth = "March", currentYear = 2026)
    }
}


@Preview
@PreviewLightDark
@Composable
fun PreviewMonthSelectorContainer() {
    MileageCounterTheme {
        MonthSelectorContainer("March")
    }
}