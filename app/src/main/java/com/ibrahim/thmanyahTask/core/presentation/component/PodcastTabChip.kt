package com.ibrahim.thmanyahTask.core.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ibrahim.thmanyahTask.ui.theme.ThmanyahTaskTheme

@Composable
fun PodcastTabChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelectionDisabled: Boolean = false,
    chipColor: Color = MaterialTheme.colorScheme.surface,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    verticalPadding: Dp = 8.dp,
) {
    Box(
        modifier =
            modifier
                .clip(RoundedCornerShape(20.dp))
                .background(
                    if (isSelected && !isSelectionDisabled) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        chipColor
                    },
                )
                .clickable { onClick() }
                .padding(horizontal = 10.dp, vertical = verticalPadding),
    ) {
        Text(
            text = text,
            color =
                if (isSelected && !isSelectionDisabled) {
                    MaterialTheme.colorScheme.onPrimary
                } else {
                    textColor
                },
            style = MaterialTheme.typography.labelMedium,
            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
        )
    }
}

@Preview
@Composable
private fun PodcastTabChipPreview() {
    ThmanyahTaskTheme {
        PodcastTabChip(
            text = "131 hrs 45 mins",
            isSelected = true,
            onClick = {},
            modifier = Modifier.padding(8.dp),
        )
    }
}
