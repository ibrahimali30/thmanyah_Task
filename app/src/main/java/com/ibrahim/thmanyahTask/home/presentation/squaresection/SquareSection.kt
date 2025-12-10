package com.ibrahim.thmanyahTask.home.presentation.squaresection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ibrahim.thmanyahTask.core.presentation.component.SectionHeader
import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.domain.model.Section

@Composable
fun SquareSection(
    section: Section,
    onContentClick: (ContentItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        SectionHeader(title = section.name)

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(section.content) { contentItem ->
                SquareContentCard(
                    contentItem = contentItem,
                    onClick = { onContentClick(contentItem) },
                )
            }
        }
    }
}
