package com.example.solarustask.core.presentation.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@SuppressLint("SimpleDateFormat")
fun formatDateAndTime(timestamp: String): Pair<String, String> {
    try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = inputFormat.parse(timestamp)

        val dateFormat = SimpleDateFormat("dd / MM / yyyy")
        val formattedDate = dateFormat.format(date)

        val timeFormat = SimpleDateFormat("hh:mm a")
        val formattedTime = timeFormat.format(date)
            .replace("AM", "صباحاً")
            .replace("PM", "مساءً")

        return Pair(formattedDate, formattedTime)

    } catch (e: Exception) {
        return Pair("", "")
    }
}