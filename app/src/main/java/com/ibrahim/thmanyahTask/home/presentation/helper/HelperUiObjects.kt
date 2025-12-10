package com.ibrahim.thmanyahTask.home.presentation.helper

import android.content.Context
import com.ibrahim.thmanyahTask.R

object HelperUiObjects {
    fun getFilterChipStrings(context: Context): List<String> {
        return listOf(
            R.string.chip_trending,
            R.string.chip_new_releases,
            R.string.chip_top_rated,
            R.string.chip_in_progress,
            R.string.chip_listened,
            R.string.chip_downloaded,
            R.string.chip_favorites,
            R.string.chip_recommended,
            R.string.chip_categories,
            R.string.chip_short_episodes,
        ).map { context.getString(it) }
    }
}
