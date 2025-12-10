package com.ibrahim.thmanyahTask.core.presentation.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier

@Composable
fun PodcastButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = primaryButtonColors(),
    ) {
        Text(text = text)
    }
}

@Composable
@Stable
fun primaryButtonColors() =
    ButtonDefaults.buttonColors().copy(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    )
