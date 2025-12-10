package com.ibrahim.thmanyahTask.core.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> PodcastTabRow(
    items: List<Pair<T, String>>, // Pair of value and display text
    selectedItem: T,
    onItemSelect: (T) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(items) { index, (value, text) ->
            PodcastTabChip(
                text = text,
                isSelected = selectedItem == value,
                onClick = {
                    onItemSelect(value)
                },
            )
        }
    }
}
