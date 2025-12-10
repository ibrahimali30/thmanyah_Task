package com.ibrahim.thmanyahTask.home.presentation.twolinessection

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.PlaylistAdd
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ibrahim.thmanyahTask.ui.theme.Pantone7545C
import com.ibrahim.thmanyahTask.core.presentation.component.PodcastNetworkImage
import com.ibrahim.thmanyahTask.core.presentation.component.PodcastTabChip
import com.ibrahim.thmanyahTask.R
import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.presentation.helper.formatDuration
import com.ibrahim.thmanyahTask.home.presentation.helper.formatToDayMonthYear

@Composable
fun TwoLinesContentCard(
    contentItem: ContentItem,
    onClick: (ContentItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clickable { onClick(contentItem) },
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
        ) {
            Text(
                text =
                    contentItem.releaseDate?.formatToDayMonthYear()
                        ?: stringResource(R.string.feature_main_hours_ago),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(),
            )
            Text(
                text = contentItem.name,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(),
            )
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
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
                Row {
                    Icon(
                        imageVector = Icons.Rounded.MoreHoriz,
                        contentDescription = "More options",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier =
                            Modifier
                                .padding(end = 4.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .clickable {
                                },
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.PlaylistAdd,
                        contentDescription = "Add to queue",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier =
                            Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .clickable {
                                },
                    )
                }
            }
        }
    }
}
