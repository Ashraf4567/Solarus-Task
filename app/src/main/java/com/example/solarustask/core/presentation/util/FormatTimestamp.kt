package com.example.solarustask.core.presentation.util

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun formatDateToArabic(timestamp: String): String {
    val formatter = DateTimeFormatter.ISO_DATE_TIME
    val dateTime = ZonedDateTime.parse(timestamp, formatter)

    val arabicLocale = Locale("ar") // we can use any locale we want

    val dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", arabicLocale)

    return dateTime.format(dateFormatter)
}

fun formatTimeToArabic(timestamp: String): String {
    val formatter = DateTimeFormatter.ISO_DATE_TIME
    val dateTime = ZonedDateTime.parse(timestamp, formatter)

    val arabicLocale = Locale("ar")

    val timeFormatter = DateTimeFormatter.ofPattern("h:mm a", arabicLocale)

    return dateTime.format(timeFormatter)
}