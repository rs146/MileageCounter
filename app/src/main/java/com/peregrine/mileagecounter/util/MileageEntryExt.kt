package com.peregrine.mileagecounter.util

import com.peregrine.mileagecounter.data.MileageEntry

fun MileageEntry.formatDateOfTravel(): String = "${date.dayOfWeek.name.uppercaseFirstLetter()}, ${date.month.name.formatMonth()} ${date.dayOfMonth}"