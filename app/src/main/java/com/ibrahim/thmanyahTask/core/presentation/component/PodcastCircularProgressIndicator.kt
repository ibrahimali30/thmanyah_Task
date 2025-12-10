package com.ibrahim.thmanyahTask.core.presentation.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun PodcastCircularProgressIndicator(
    modifier: Modifier = Modifier,
) {
    CircularProgressIndicator(
        modifier = modifier.testTag("loadingIndicator"),
        color = MaterialTheme.colorScheme.primary,
        strokeWidth = 3.dp,
        strokeCap = StrokeCap.Round,
    )
}
