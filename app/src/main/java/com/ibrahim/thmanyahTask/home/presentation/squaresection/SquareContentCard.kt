package com.ibrahim.thmanyahTask.home.presentation.squaresection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ibrahim.thmanyahTask.ui.theme.Pantone7545C
import com.ibrahim.thmanyahTask.core.presentation.component.PodcastNetworkImage
import com.ibrahim.thmanyahTask.core.presentation.component.PodcastTabChip
import com.ibrahim.thmanyahTask.R
import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.presentation.helper.formatDuration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Composable
fun SquareContentCard(
    contentItem: ContentItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(4.dp),
    ) {
        PodcastNetworkImage(
            imageUrl = contentItem.avatarUrl,
            contentDescription = null,
            modifier =
                Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onClick() },
            contentScale = ContentScale.Crop,
        )

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
            horizontalArrangement =
                Arrangement.spacedBy(
                    6.dp,
                    alignment = Alignment.Start,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PodcastTabChip(
                text = contentItem.duration.formatDuration(),
                isSelected = false,
                isSelectionDisabled = true,
                onClick = {},
                chipColor = Pantone7545C,
                textColor = Color.White,
                verticalPadding = 4.dp,
            )
            Text(
                text = stringResource(R.string.feature_main_today),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 2.dp),
            )
        }
    }
}
