package com.ibrahim.thmanyahTask.core.presentation.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PodcastCenterAlignedTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            navigationIcon()
        },
        windowInsets = WindowInsets(0, 0, 0, 0),
    )
}

@Preview
@Composable
private fun PodcastCenterAlignedTopAppBarPreview() {
    PodcastCenterAlignedTopAppBar(
        title = "Podcast App",
        modifier = Modifier,
    )
}
