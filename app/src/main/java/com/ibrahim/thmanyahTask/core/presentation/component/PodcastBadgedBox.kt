package com.ibrahim.thmanyahTask.core.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PodcastBadgedBox(
    modifier: Modifier = Modifier,
) {
    BadgedBox(
        badge = {
            Badge(
                modifier = Modifier.offset(y = (-4).dp, x = (-5).dp),
                containerColor = MaterialTheme.colorScheme.error,
                contentColor = MaterialTheme.colorScheme.onError,
            ) {
                Text(
                    "4",
                    modifier = Modifier.semantics { contentDescription = "new notifications" },
                    fontWeight = FontWeight.ExtraBold,
                )
            }
        },
    ) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Notifications",
            tint = MaterialTheme.colorScheme.onSurface,
            modifier =
                Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .clickable {
                    },
        )
    }
}
