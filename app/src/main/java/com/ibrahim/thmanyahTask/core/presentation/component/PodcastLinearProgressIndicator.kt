package com.ibrahim.thmanyahTask.core.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahim.thmanyahTask.ui.theme.ThmanyahTaskTheme

@Composable
fun PodcastLinearProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
) {
    LinearProgressIndicator(
        progress = { progress },
        modifier = modifier.fillMaxWidth(),
        gapSize = 0.dp,
        color = MaterialTheme.colorScheme.primary,
        trackColor = MaterialTheme.colorScheme.background.copy(alpha = 0.12f),
    )
}

@Preview(showBackground = true)
@Composable
private fun PodcastLinearProgressIndicatorPreview() {
    ThmanyahTaskTheme {
        PodcastLinearProgressIndicator(
            progress = 0.7f,
        )
    }
}
