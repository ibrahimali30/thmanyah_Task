package com.ibrahim.thmanyahTask.home.presentation.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import com.ibrahim.thmanyahTask.R
@Composable
fun Long.formatDuration(): String {
    val minutes = this / 60
    return when {
        minutes < 60 -> "${minutes}${stringResource(R.string.core_ui_short_mins)}"
        else -> {
            val hours = minutes / 60
            val remainingMinutes = minutes % 60
            "${hours}${stringResource(R.string.core_ui_short_hour)} " +
                "${remainingMinutes}${stringResource(R.string.core_ui_short_mins)}"
        }
    }
}

fun String.formatToDayMonthYear(): String {
    return try {
        val zonedDateTime = ZonedDateTime.parse(this)
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        zonedDateTime.format(formatter)
    } catch (e: Exception) {
        "" // or a fallback like "Invalid date"
    }
}
