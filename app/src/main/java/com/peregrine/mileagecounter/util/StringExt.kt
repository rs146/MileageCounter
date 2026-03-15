package com.peregrine.mileagecounter.util

fun String.uppercaseFirstLetter(): String = this.lowercase().replaceFirstChar { it.uppercase() }

fun String.formatMonth(): String = if (this.contains("September")) this.uppercaseFirstLetter()
    .take(4) else this.uppercaseFirstLetter().take(3)