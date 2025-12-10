package com.ibrahim.thmanyahTask.home.presentation.twolinessection


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ibrahim.thmanyahTask.core.presentation.component.SectionHeader
import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.domain.model.Section

@Composable
fun TwoLinesGridSection(
    section: Section,
    onContentClick: (ContentItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        SectionHeader(title = section.name)
        LazyHorizontalGrid(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
            rows = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(section.content) { contentItem ->
                TwoLinesContentCard(
                    contentItem = contentItem,
                    onClick = { onContentClick(contentItem) },
                    modifier = Modifier.width(240.dp),
                )
            }
        }
    }
}
