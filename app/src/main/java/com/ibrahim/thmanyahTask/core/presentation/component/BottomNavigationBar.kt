package com.ibrahim.thmanyahTask.core.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahim.thmanyahTask.ui.theme.ThmanyahTaskTheme

@Composable
fun BottomNavigationBar(
    navigationItems: List<NavigationItem>,
    modifier: Modifier = Modifier,
    selectedTab: Int = 0,
    onTabSelect: (Int) -> Unit = {},
) {
    var isSelected by remember { mutableStateOf(false) }
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
                    .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            navigationItems.forEachIndexed { index, item ->
                isSelected = index == selectedTab
                NavigationButton(
                    icon = if (isSelected) item.selectedIcon else item.unselectedIcon,
                    label = item.label,
                    isSelected = isSelected,
                    onClick = { onTabSelect(index) },
                )
            }
        }
    }
}

data class NavigationItem(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val label: String,
)

@Composable
@Preview(showBackground = true)
private fun PreviewBottomNavigationBar() {
    ThmanyahTaskTheme() {
        val navigationItems =
            listOf(
                NavigationItem(
                    Icons.Rounded.Home,
                    Icons.Outlined.Home,
                    "الرئيسية",
                ),
                NavigationItem(
                    Icons.Rounded.Search,
                    Icons.Outlined.Search,
                    "البحث",
                ),
            )
        BottomNavigationBar(navigationItems)
    }
}
