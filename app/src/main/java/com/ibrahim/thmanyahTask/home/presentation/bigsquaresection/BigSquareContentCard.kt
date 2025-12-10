package com.ibrahim.thmanyahTask.home.presentation.bigsquaresection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ibrahim.thmanyahTask.R
import com.ibrahim.thmanyahTask.core.presentation.component.PodcastNetworkImage
import com.ibrahim.thmanyahTask.home.data.model.ContentItem


@Composable
fun BigSquareContentCard(
    contentItem: ContentItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.padding(4.dp),
    ) {
        PodcastNetworkImage(
            imageUrl = contentItem.avatarUrl,
            contentDescription = contentItem.name,
            modifier =
                Modifier
                    .width(220.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onClick() },
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier =
                Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(bottom = 6.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = contentItem.podcastName ?: contentItem.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 2.dp),
            )
            if ((contentItem.episodeCount ?: 0) > 0) {
                Text(
                    text = "${contentItem.episodeCount} ${stringResource(R.string.core_ui_episode)}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 2.dp),
                )
            }
        }
    }
}
