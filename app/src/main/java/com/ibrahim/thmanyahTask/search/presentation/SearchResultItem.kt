package com.example.feature.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahim.thmanyahTask.core.presentation.component.PodcastCard
import com.ibrahim.thmanyahTask.core.presentation.component.PodcastNetworkImage
import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.ui.theme.ThmanyahTaskTheme

@Composable
fun SearchResultItem(
    contentItem: ContentItem,
    modifier: Modifier = Modifier,
) {
    PodcastCard(
        modifier =
            modifier
                .fillMaxWidth(),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PodcastNetworkImage(
                imageUrl = contentItem.avatarUrl,
                contentDescription = null,
                modifier =
                    Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                if (contentItem.name.isNotBlank()) {
                    Text(
                        text = contentItem.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                if (!contentItem.authorName.isNullOrBlank()) {
                    Text(
                        text = contentItem.authorName!!,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                if (!contentItem.podcastName.isNullOrBlank()) {
                    Text(
                        text = contentItem.podcastName!!,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun SearchResultItemPreview() {
    ThmanyahTaskTheme() {
        SearchResultItem(
            contentItem =
                ContentItem(
                    name = "Sample Podcast Episode",
                    authorName = "John Doe",
                    podcastName = "Tech Talks",
                    description = "An insightful discussion on technology trends.",
                    avatarUrl = "https://example.com/avatar.jpg",
                    duration = 47431,
                ),
        )
    }
}
